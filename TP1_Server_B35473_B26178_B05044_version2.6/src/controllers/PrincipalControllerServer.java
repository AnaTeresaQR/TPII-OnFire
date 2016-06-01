package controllers;

import factorySale.ConcreteFactorySale;
import factorySale.FactorySaleInterface;
import java.io.IOException;
import java.util.Calendar;
import managementAdministrator.ManagementAdministrator;
import models.SaleModel;
import models.UserModel;
import salesBuilder.AbstractBuilderCreateSale;
import server.Server;
import usersBuilder.ConcreteBuilderCreateUser;
import usersBuilder.CustomException;
import usersBuilder.Director;
import views.AdministratorMenuView;
import views.LoginAdministrator;
import views.WelcomeServerView;

/**
 *
 * @author Ana Teresa
 */
public class PrincipalControllerServer {

    private Server server;
    private boolean canLoginAdmin;
    private UserModel modelUser;
    private SaleModel saleModel;
    private Director director;
    private FactorySaleInterface factorySales;

    private LoginAdministrator loginView;
    private WelcomeServerView principalServer;
    private AdministratorMenuView menuServer;

    public PrincipalControllerServer(Server server) {
        this.server = server;
        System.out.println("1");
        director = new Director();
        System.out.println("2");
        this.saleModel = new SaleModel();
        this.modelUser = new UserModel();
        factorySales = new ConcreteFactorySale();
    }

    public void NoConnection(PrincipalControllerServer controller) {
        if (principalServer == null) {
            principalServer = new WelcomeServerView(controller);
        }
        principalServer.setVisible(true);
    }

    public void processAdministrator(PrincipalControllerServer controller) throws IOException {
        if (loginView == null) {
            this.loginView = new LoginAdministrator(controller);
        }
        loginView.setVisible(true);
    }

    public synchronized boolean processLoginAdministrator(String admin, String password) {
        ManagementAdministrator ma = new ManagementAdministrator();
        this.canLoginAdmin = ma.login(admin, password);
        return canLoginAdmin;
    }

    public PrincipalControllerServer() {
        this.server = new Server();
    }

    public boolean createUser(String id, String name, String email, String password, Calendar birthdate, String phoneNumber) throws IOException, CustomException {
        director.createUser(new ConcreteBuilderCreateUser(), modelUser, id, name, email, password, birthdate, phoneNumber);
        boolean resultCreateModel = modelUser.createModel();
        modelUser.save();
        return resultCreateModel;
    }

    public void loadFile() {
        modelUser.listLoader(); // update list
    }

    public UserModel loginUser(String email, String password) throws IOException {
        loadFile();
        UserModel temp = modelUser.login(email, password);
        if (temp != null) {
            modelUser = temp;
        }
        return temp;
    }

    public void processMenuAdministrator(PrincipalControllerServer controller) {
        if (menuServer == null) {
            menuServer = new AdministratorMenuView(controller);
        }
        menuServer.setVisible(true);
    }

    public boolean createSaleBuilder(AbstractBuilderCreateSale abstractBuilderSale, String brand, String model, int year, String carId, String color, String description, int days, int minOffer) throws IOException, CustomException {
        factorySales.createSale(abstractBuilderSale, saleModel, modelUser, brand, model, year, carId, color, description, days, minOffer);
        boolean resultCreateModel = saleModel.createModel();
        
        saleModel.save();
        return resultCreateModel;
    }
}
