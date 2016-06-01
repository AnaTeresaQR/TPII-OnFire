package controllers;

import factorySale.ConcreteFactorySale;
import factorySale.FactorySaleInterface;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
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
        director = new Director();
        this.saleModel = new SaleModel();
        this.modelUser = new UserModel();
        loadFile();
        loadFileSale();
//        System.out.println("tamaño lista: " + SaleModel.getSaleListManager().getWaitingApproveSalesList().size());
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
        if (resultCreateModel) {
            modelUser.save();
        }
        return resultCreateModel;
    }

    private void loadFile() {
        modelUser.listLoader(); // update list

        System.out.println("users: " + modelUser.size());

    }

    private void loadFileSale() {
        saleModel.listLoader();
        
        
        //System.out.println("sales: " + SaleModel.getSaleListManager().getWaitingApproveSalesList().get(0).getCarId());
    }

    public UserModel loginUser(String email, String password) throws IOException {
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
        saleModel = factorySales.createSale(abstractBuilderSale, saleModel, modelUser, brand, model, year, carId, color, description, days, minOffer);
        boolean resultCreateModel = saleModel.createModel();
        if (resultCreateModel) {
            System.out.println("controlador server create Sale" + saleModel.getCarId());
            saleModel.save();
        }
        return resultCreateModel;
    }

    public List<SaleModel> showWaitingListSale() {
        List<SaleModel> newList = SaleModel.getSaleListManager().getWaitingApproveSalesList();
        return newList;
    }
}
