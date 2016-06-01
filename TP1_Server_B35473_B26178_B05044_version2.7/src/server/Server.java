package server;

import controllers.PrincipalControllerServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Edgardo Quirós
 */
public class Server {

    private ServerSocket server;
    private Socket connection;
    private final int PORT = 8080;
    private AcceptClient acceptClient;
    private PrincipalControllerServer controller;

    public void runServer() {

        try {
            server = new ServerSocket(PORT);
            controller = new PrincipalControllerServer(this);
            controller.NoConnection(controller);
            while (true) {
                waitForConnection();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException {
        System.out.println("Waiting for connection...\n");
        connection = server.accept();
        System.out.println("Connection received from: " + connection.getInetAddress().getHostName());
        acceptClient = new AcceptClient(connection, controller);
        acceptClient.start();

    }

    private void closeServer() {
        System.out.println("\nTerminating server");
        try {
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Server().runServer();
    }
}
