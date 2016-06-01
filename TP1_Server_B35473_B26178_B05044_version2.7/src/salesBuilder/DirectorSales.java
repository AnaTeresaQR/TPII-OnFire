package salesBuilder;

import java.util.Date;
import models.SaleModel;
import usersBuilder.CustomException;
import models.UserModel;

/**
 * Class is responsible for creating the sale object completely, with all its
 * parts verified
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class DirectorSales {

    /**
     * Method that is responsible for validating every part of creation, before
     * returning the object
     *
     * @param builder, the instance of the concrete parts creator
     * @param saleModel, the model object of the sale
     * @param date, the sale date
     * @param user, the sale user
     * @param brand, the sale brand
     * @param model, the sale model
     * @param year, the sale year
     * @param carId, the sale carId
     * @param color, the sale color
     * @param description, the sale description
     * @param days, the sale days
     * @param minOffer, the sale minnOffer
     * @return the sale completely validate
     * @throws CustomException if could not create one of the parties
     */
    public SaleModel createSale(AbstractBuilderCreateSale builder, SaleModel saleModel, UserModel user, String brand, String model, int year, String carId, String color, String description, int days, int minOffer) throws CustomException {
        if (builder == null) {
            throw new CustomException("No es posible crear  la subasta");
        }

        builder.buildSale(saleModel);
        builder.createSpecificSale();
        builder.buildUser(user);
        builder.buildBrand(brand);
        builder.buildModel(model);
        builder.buildYear(year);
        builder.buildCarId(carId);
        builder.buildColor(color);
        builder.buildDescription(description);
        builder.buildDays(days);
        builder.buildMinOffer(minOffer);
        return builder.getSale();
    }

}
