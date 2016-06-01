package salesBuilder;

import java.util.Date;
import models.SaleModel;
import usersBuilder.CustomException;
import models.UserModel;

/**
 * interface that contains the declaration of the methods needed to build parts
 * of a sale
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public interface AbstractBuilderCreateSale {

    public void buildSale(SaleModel sale);

    public void buildDate(Date date) throws CustomException;

    public void buildUser(UserModel user) throws CustomException;

    public void buildBrand(String brand) throws CustomException;

    public void buildModel(String model) throws CustomException;

    public void buildYear(int date) throws CustomException;

    public void buildCarId(String carId) throws CustomException;

    public void buildColor(String color) throws CustomException;

    public void buildDescription(String Description) throws CustomException;

    public void buildDays(int days) throws CustomException;

    public void buildMinOffer(int minOffer) throws CustomException;

    public abstract void createSpecificSale();

    public SaleModel getSale() throws CustomException;

}
