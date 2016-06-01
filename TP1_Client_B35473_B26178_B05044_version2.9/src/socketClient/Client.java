package socketClient;

import controllers.ManageSalesController;
import controllers.PrincipalController;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class Client {

    private DataInputStream input;
    private DataOutputStream output;

    private ObjectInputStream inputObj;
    private ObjectOutputStream outputObj;

    private Socket client;
    private final String HOST = "localhost";
    private final int PORT = 8080;

    private PrincipalController controller;
    private ManageSalesController controllerSales;

    public Client() {
        controllerSales = new ManageSalesController(this);
        controller = new PrincipalController(this, controllerSales);

    }

    public void runClient() {
        try {

            connectToServer();
            getStreams();
            controller.processConnection();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void connectToServer() throws IOException {
        System.out.println("Attempting connection\n");
        client = new Socket(HOST, PORT);
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
    }

    private void getStreams() throws IOException {
        output = new DataOutputStream(client.getOutputStream());
        output.flush();
        input = new DataInputStream(client.getInputStream());

        outputObj = new ObjectOutputStream(client.getOutputStream());
        outputObj.flush();
        inputObj = new ObjectInputStream(client.getInputStream());

    }

    public void closeStream() {
        try {
            output.close();
            input.close();
            outputObj.close();
            inputObj.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void closeConnection() {
        System.out.println("\nClosing connection");
        try {
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean processRegisterUser(String id, String name, String email, String password, Calendar birthdate, String phoneNumber) {
        boolean status = false;
        try {

            output.writeUTF(id);
            output.writeUTF(name);
            output.writeUTF(email);
            output.writeUTF(password);
            outputObj.writeObject(birthdate);
            output.writeUTF(phoneNumber);
            status = input.readBoolean();
            return status;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void processSelectAction(int num) throws IOException {
        output.writeInt(num);
    }

    public void processConfirmationAction(Boolean confirmation) throws IOException {
        output.writeBoolean(confirmation);
    }

    public int processLoginUser(String email, String password) {
        try {

            output.writeUTF(email);
            output.writeUTF(password);

            return input.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean processRegisterSale(String brand, String model, int year, String carId, String color, String description, int days, long minOffer, int typeSale) {
        boolean status = false;
        try {
            output.writeUTF(brand);
            output.writeUTF(model);
            output.writeInt(year);
            output.writeUTF(carId);
            output.writeUTF(color);
            output.writeUTF(description);
            output.writeInt(days);
            output.writeLong(minOffer);
            output.writeInt(typeSale);
            status = input.readBoolean();
            return status;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static void main(String[] args) {
        new Client().runClient();
    }

    public void sendEmail(String email) throws IOException {
        output.writeUTF(email);
    }

    public Map<String, String> getOwnSalesTreeProcess() throws IOException, ClassNotFoundException {
        return (TreeMap<String, String>) inputObj.readObject();
    }

}
