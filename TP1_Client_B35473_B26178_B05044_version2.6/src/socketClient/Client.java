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

    }

    public void runClient() {
        try {

            connectToServer();
            controller = new PrincipalController(this);
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

    private void closeConnection() {
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

    public String processRegisterSale(String brand, String model, int year, String carId, String color, String description, int days, int minOffer, int typeSale) {
        String messageConfirmation = "";
        try {
            output.writeUTF(brand);
            output.writeUTF(model);
            output.writeInt(year);
            output.writeUTF(carId);
            output.writeUTF(color);
            output.writeUTF(description);
            output.writeInt(days);
            output.writeInt(minOffer);
            output.writeInt(typeSale);
            messageConfirmation = input.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messageConfirmation;
    }

    public static void main(String[] args) {
        new Client().runClient();
    }

}
