package controllers;

import socketClient.Client;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import javax.swing.JFrame;
import views.LoginUserView;
import views.PrincipalView;
import views.RegisterSaleView;
import views.RegisterUserView;
import views.ShowOwnSalesView;
import views.UserMenuView;

/**
 *
 * @author Ana Teresa
 */
public class PrincipalController {

    private Client client;

    private PrincipalView principal;

    private LoginUserView login;
    private UserMenuView menu;
    private RegisterUserView registerUser;
    private ShowOwnSalesView manageUserSales;
    private RegisterSaleView registerSale;

    private ManageSalesController manageSalesController;
    
    private String emailSession;
    
    private Map<String, String> ownSalesList;

    public PrincipalController(Client client, ManageSalesController manageSalesController) {
        this.client = client;
        this.manageSalesController = manageSalesController;
    }

    public void selectAction(int num) throws IOException {
        client.processSelectAction(num);
    }

    public boolean createUser(String id, String name, String email, String password, Calendar birthdate, String phoneNumber) throws IOException {
        boolean canRegister = client.processRegisterUser(id, name, email, password, birthdate, phoneNumber);
        return canRegister;
    }

    public String messageRegister(boolean canRegister) {
        String messageStatus = "";
        if (canRegister) {
            messageStatus += "Se pudo registrar correctamente";
        } else {
            messageStatus += "No es posible registrar el usuario";
        }
        return messageStatus;
    }

    public int loginUser(String email, String password) {
        return client.processLoginUser(email, password);
    }

    public void loginUser(PrincipalController controller) {
        if (login == null) {
            login = new LoginUserView(controller);
        }
        login.setVisible(true);
    }

    public void showMenu(PrincipalController controller, JFrame child) {
        child.dispose();
        if (menu == null) {
            menu = new UserMenuView(controller);
        }
        menu.setVisible(true);
    }

    public void showMenu(PrincipalController controller) {
        if (menu == null) {
            menu = new UserMenuView(controller);
        }
        menu.setVisible(true);
    }

    public void registerUser(PrincipalController controller) throws IOException {
        if (registerUser == null) {
            registerUser = new RegisterUserView(controller);
        }
        registerUser.setVisible(true);
    }

    public void showManageSale(PrincipalController controller, JFrame parent) {
        parent.dispose();
        if (manageUserSales == null) {
            manageUserSales = new ShowOwnSalesView(controller, manageSalesController);
        }
        manageUserSales.setVisible(true);
    }

    public void showAddSale(ManageSalesController manageSaleController, JFrame child) {
        child.dispose();
        if (registerSale == null) {
            registerSale = new RegisterSaleView(this, manageSaleController);
        }
        registerSale.setVisible(true);
    }

    public void processConnection() throws IOException {
        returnView(this);
    }

    public void returnView(PrincipalController controller) throws IOException {
        if (principal == null) {
            principal = new PrincipalView(controller);
        }
        principal.setVisible(true);
    }

    public void returnView(PrincipalController controller, JFrame child) throws IOException {
        child.dispose();
        if (principal == null) {
            principal = new PrincipalView(controller);
        }
        principal.setVisible(true);
    }

    public void processConfirmationAction(Boolean confirmation) throws IOException {
        client.processConfirmationAction(confirmation);
    }

    public void exitOnClose() {
        client.closeConnection();
    }

    public Map<String, String> getOwnSalesTree() {
        return this.ownSalesList;
    }
    
    public void sendEmail() throws IOException{
        client.sendEmail(emailSession);
    }
    
    public void setEmailSession(String emailSession){
        this.emailSession = emailSession;
    }
    
    public void getLoadedMap() throws IOException, ClassNotFoundException{
        this.ownSalesList = client.getOwnSalesTreeProcess();
    }

}
