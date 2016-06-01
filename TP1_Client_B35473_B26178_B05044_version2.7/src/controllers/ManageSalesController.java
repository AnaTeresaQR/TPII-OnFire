package controllers;

import java.io.IOException;
import javax.swing.JFrame;
import socketClient.Client;
import views.RegisterSaleView;
import views.ShowOwnSalesView;

/**
 *
 * @author Ana Teresa
 */
public class ManageSalesController {

    private Client client;
    private ShowOwnSalesView showOwnView;

    public ManageSalesController(Client client) {
        this.client = client;
    }

    public boolean createSale(String brand, String model, int year, String carId, String color, String description, int days, int minOffer, int typeSale) throws IOException {
        return client.processRegisterSale(brand, model, year, carId, color, description, days, minOffer, typeSale);
    }

    public String messageRegisterSale(boolean canRegister) {
        String messageStatus = "";
        if (canRegister) {
            messageStatus += "Se pudo registrar correctamente la subasta";
        } else {
            messageStatus += "No es posible registrar la subasta";
        }
        return messageStatus;
    }

    public void selectActionAddSale(int num) throws IOException {
        client.processSelectAction(num);
    }

    public void returnView(PrincipalController principalController, JFrame child) {
        child.dispose();
        if (showOwnView == null) {
            showOwnView = new ShowOwnSalesView(principalController, this);
        }
        showOwnView.setVisible(true);
    }

    public void processConfirmationAction(Boolean confirmation) throws IOException {
        client.processConfirmationAction(confirmation);
    }

}
