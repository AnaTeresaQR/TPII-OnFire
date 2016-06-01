package controllers;

import java.io.IOException;
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
    private RegisterSaleView registerSale;

    public ManageSalesController(Client client) {
        this.client = client;
    }

    public String createSale(String brand, String model, int year, String carId, String color, String description, int days, int minOffer, int typeSale) throws IOException {
        return client.processRegisterSale(brand, model, year, carId, color, description, days, minOffer, typeSale);
    }

    public void selectActionAddSale(int num) throws IOException {
        client.processSelectAction(num);
    }

//    public void returnView(PrincipalController controller) {
//        if (showOwnView == null) {
//            showOwnView = new ShowOwnSalesView(controller);
//        }
//        showOwnView.setVisible(true);
//    }
    public void returnView() {
        showOwnView.setVisible(true);
    }

    public void showRegisterSaleView(ManageSalesController controller) {
        if (registerSale == null) {
            registerSale = new RegisterSaleView(controller);
        }
        registerSale.setVisible(true);
    }

}
