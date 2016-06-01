package factorySale;

import java.util.Date;
import salesBuilder.AbstractBuilderCreateSale;
import models.SaleModel;
import usersBuilder.CustomException;
import models.UserModel;

/**
 * Class used to overwrite the method to create a new Sale
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada
 */
public class ConcreteFactorySale extends FactorySaleInterface {

    /**
     * Method used to create a new Sale
     *
     * @param builder used to create a specific sale
     * @param saleModel model of sale to create.
     * @param date initial date of sale.
     * @param user user that created sale.
     * @param brand brand of the car sale.
     * @param model model of the car sale.
     * @param year year of the car sale.
     * @param carId id of the car sale.
     * @param color color of the car sale.
     * @param description description of the car sale.
     * @param days days duration sale
     * @param minOffer minimum offer sale.
     * @return New sale
     * @throws CustomException problems to create sale.
     */
    @Override
    public SaleModel createSale(AbstractBuilderCreateSale builder, SaleModel saleModel, UserModel user, String brand, String model, int year, String carId, String color, String description, int days, int minOffer) throws CustomException {

        SaleModel sale = director.createSale(builder, saleModel, user, brand, model, year, carId, color, description, days, minOffer);
        return sale;

    }

}
