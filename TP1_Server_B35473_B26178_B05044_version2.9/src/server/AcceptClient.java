package server;

import controllers.PrincipalControllerServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Calendar;
import models.UserModel;
import salesBuilder.AbstractBuilderCreateSale;
import salesBuilder.ConceteBuilderCloseSale;
import salesBuilder.ConcreteBuilderOpenSale;
import usersBuilder.CustomException;

/**
 *
 * @author Ana Teresa
 */
public class AcceptClient extends Thread {

    private DataOutputStream output;
    private DataInputStream input;

    private ObjectInputStream inputObj;
    private ObjectOutputStream outputObj;
    private final Socket connection;

    private PrincipalControllerServer controller;
    private AbstractBuilderCreateSale abstractBuilderSale;

    private UserModel userModel;

    private boolean option;

    public AcceptClient() {
        this.connection = null;
        this.userModel = new UserModel();
    }

    public AcceptClient(Socket connection, PrincipalControllerServer controller) {
        this.connection = connection;
        this.controller = controller;
        this.userModel = new UserModel();
    }

    @Override
    public void run() {
        try {
            executeRun();
            processMenuSelectAction();
        } catch (IOException ex) {
            System.out.println("Conección terminada: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (CustomException ex) {
            ex.printStackTrace();
        }
    }

    public void executeRun() throws IOException, ClassNotFoundException, CustomException {
        getStreams();
        userModel.listLoader();
        processUserSelectAction();
    }

    private void closeConnection() {
        System.out.println("\nTerminating connection\n\n");
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void getStreams() throws IOException {
        output = new DataOutputStream(connection.getOutputStream());
        output.flush();
        input = new DataInputStream(connection.getInputStream());

        outputObj = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        inputObj = new ObjectInputStream(connection.getInputStream());
    }

    private void closeStream() throws IOException {
        output.close();
        input.close();
    }

    public void processUserSelectAction() throws IOException, ClassNotFoundException, CustomException {
        int selection = input.readInt();
        switch (selection) {
            case 1:
                processRegisterUser();
                break;
            case 2:
                processLoginUser();
                break;
            default:
                throw new AssertionError();
        }
    }

    public void processMenuSelectAction() throws IOException, CustomException, ClassNotFoundException {
        int selection = input.readInt();
        switch (selection) {
            case 6:
                processManageSales();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void processManageSales() throws IOException, CustomException, ClassNotFoundException {
        int selection = input.readInt();
        switch (selection) {
            case 0:
                processMenuSelectAction();

                break;
            case 4:
                processRegisterSale();
                break;
            default:
                throw new AssertionError();
        }
    }

    public void processRegisterUser() throws IOException, ClassNotFoundException, CustomException {
        // I need to know if the user want to be register or not
        Boolean confirmation = input.readBoolean();
        if (confirmation) {
            String schedule = input.readUTF();
            String name = input.readUTF();
            String email = input.readUTF();
            String password = input.readUTF();
            Calendar birthdate = (Calendar) inputObj.readObject();
            String phonenumber = input.readUTF();
            boolean userBuild = controller.createUser(schedule, name, email, password, birthdate, phonenumber);
            if (userBuild) {
                output.writeBoolean(userBuild);
            } else {
                output.writeBoolean(userBuild);
                processUserSelectAction();
            }
        } else {
            // I have to wait to another order
            processUserSelectAction();
        }
    }

    public void processLoginUser() throws IOException, ClassNotFoundException, CustomException {
        // I need to know if the user want to be register or not
        boolean confirmation = input.readBoolean();
        if (confirmation) {
            String email = input.readUTF();
            String password = input.readUTF();
            UserModel userlogin = controller.loginUser(email, password);
            if (userlogin != null) {
                output.writeInt(1);
            } else {
                output.writeInt(-1);
                // I have to wait to another order
                processUserSelectAction();
            }
        } else {
            // I have to wait to another order
            processUserSelectAction();
        }
    }

    public void processRegisterSale() throws CustomException, IOException, ClassNotFoundException {
        boolean confirmation = input.readBoolean();

        if (confirmation) {
            String brand = input.readUTF();
            String model = input.readUTF();
            int year = input.readInt();
            String id = input.readUTF();
            String color = input.readUTF();
            String description = input.readUTF();
            int days = input.readInt();
            long minOffer = input.readLong();
            int typeSale = input.readInt();

            if (typeSale == 0) {
                abstractBuilderSale = new ConcreteBuilderOpenSale();
            } else {
                if (typeSale == 1) {
                    abstractBuilderSale = new ConceteBuilderCloseSale();
                }
            }

            boolean saleBuildStatus = controller.createSaleBuilder(abstractBuilderSale, brand, model, year, id, color, description, days, minOffer);
            if (saleBuildStatus) {
                output.writeBoolean(saleBuildStatus);
                processManageSales();
            } else {
                output.writeBoolean(saleBuildStatus);
                processManageSales();
            }
        } else {
            processManageSales();
        }
    }

}
