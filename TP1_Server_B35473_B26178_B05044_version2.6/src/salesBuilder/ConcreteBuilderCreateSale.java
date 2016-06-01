package salesBuilder;

import enums.EnumSale;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.SaleModel;
import usersBuilder.CustomException;
import models.UserModel;

/**
 * Class that implements AbstractBuilderCreateSale and defines methods to create
 * a sale
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public abstract class ConcreteBuilderCreateSale implements AbstractBuilderCreateSale {

    private SaleModel sale;
    private boolean check;

    @Override
    public void buildSale(SaleModel sale) {
        this.sale = sale;
    }

    /**
     * Returns a sale if all parts have been validated with regular expressions
     *
     * @return @throws CustomException if any parts could not be created
     * correctly
     */
    @Override
    public SaleModel getSale() throws CustomException {
        return sale;
    }

    /**
     * Builds date if it is not empty or null
     *
     * @param date, the date of the sale
     * @throws CustomException, if can not set the date
     */
    @Override
    public void buildDate(Date date) throws CustomException {
        if (date != null) {
            sale.setInitialDate(date);
        } else {
            throw new CustomException("La fecha no puede estar vacia");
        }

    }

    /**
     * Builds user if it is not empty or null
     *
     * @param user, the user sale
     * @throws CustomException, if can not set the user
     */
    @Override
    public void buildUser(UserModel user) throws CustomException {
        if (user != null) {
            sale.setUser(user);
        } else {
            throw new CustomException("EL usuario perteneciente a esta subasta no fue creado correctamente");
        }

    }

    /**
     * Builds brand if it is not empty or null
     *
     * @param brand, the brand of the car sale
     * @throws CustomException, if can not set the brand
     */
    @Override
    public void buildBrand(String brand) throws CustomException {
        if (brand != null
                && !brand.equals("")
                && checkBrand(brand)) {
            sale.setBrand(brand);
        } else {
            throw new CustomException("La extensión de la marca excede el tamaño permitido,"
                    + " debe ser menor a 15 caracteres, y no debe contener caracteres especiales.");
        }

    }

    /**
     * Builds model if it is not empty or null
     *
     * @param model, the model of the car sale
     * @throws CustomException, if can not set the name
     */
    @Override
    public void buildModel(String model) throws CustomException {
        if (model != null
                && !model.equals("")
                && checkModel(model)) {
            sale.setModel(model);
        } else {
            throw new CustomException("La extensión del modelo excede el tamaño permitido,"
                    + " debe ser menor a 15 caracteres, y no debe contener caracteres especiales.");
        }
    }

    /**
     * Builds year if it is not 0 or if it is between 1900 and 2016
     *
     * @param year, the year of the car sale
     * @throws CustomException if can not set the year
     */
    @Override
    public void buildYear(int year) throws CustomException {
        if (year != 0
                && year > EnumSale.MIN_YEAR.getNums()
                && year < EnumSale.MAX_YEAR.getNums()) {
            sale.setYear(year);
        } else {
            throw new CustomException("No es posible guardar el año");
        }
    }

    /**
     * Builds carId if it is not empty or null
     *
     * @param carId, the car id of the sale
     * @throws CustomException if can not set carId
     */
    @Override
    public void buildCarId(String carId) throws CustomException {
        if (carId != null
                && !carId.equals("")
                && checkCarId(carId)) {
            sale.setCarId(carId);
        } else {
            throw new CustomException("La matricula del carro no coincide con el tipo de matricula permitida en Costa Rica");
        }
    }

    /**
     * Check Color if it is not null or empty
     *
     * @param color, receives the car sale color
     * @throws CustomException if can not set the color of the car sale
     */
    @Override
    public void buildColor(String color) throws CustomException {
        if (color != null
                && !color.equals("")
                && checkColor(color)) {
            sale.setColor(color);
        } else {
            throw new CustomException("El color del auto no debe contener caracteres especiales ni números,"
                    + " debe ser menor a 15 caracteres.");
        }
    }

    /**
     * Builds description if it is not null
     *
     * @param description , the description of the sale
     * @throws CustomException if can not set the description
     */
    @Override
    public void buildDescription(String description) throws CustomException {
        if (description != null && checkDescription(description)) {
            sale.setDescription(description);
        } else {
            throw new CustomException("La extensión de la description excede el tamaño permitido, debe ser menor a 200 caracteres.");
        }
    }

    /**
     * Builds description if it is not 0 or if it is not more than 7
     *
     * @param days , the days of the sale
     * @throws CustomException if can not set days
     */
    @Override
    public void buildDays(int days) throws CustomException {
        if (days > 0 && days <= EnumSale.MAX_SALE_DAYS.getNums()) {
            sale.setDays(days);
        } else {
            throw new CustomException("No es posible guardar la cantidad de dias restantes");
        }

    }

    /**
     * Builds minOffer if it is bigger than 100000
     *
     * @param minOffer, the minOffer of the sale
     * @throws CustomException if can not set minOffer
     */
    @Override
    public void buildMinOffer(int minOffer) throws CustomException {
        if (minOffer >= EnumSale.MIN_SALE_OFFER.getNums()) {
            sale.setMinOffer(minOffer);
        } else {
            throw new CustomException("No es posible guardar la cantidad minima ofertada");
        }

    }

    /**
     * Check the brand, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkBrand(String brand) {

        Pattern pat = Pattern.compile("[a-zA-Z0-9]{0,15}");
        Matcher mat = pat.matcher(brand);
        check = mat.matches();
        return check;
    }

    /**
     * Check the model, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkModel(String model) {

        Pattern pat = Pattern.compile("[a-zA-Z0-9]{0,15}");
        Matcher mat = pat.matcher(model);
        check = mat.matches();
        return check;
    }

    /**
     * Check the carIdOldType, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkCarIdOldType(String carOldId) {

        Pattern pat = Pattern.compile("[0-9]{6}");
        Matcher mat = pat.matcher(carOldId);
        check = mat.matches();
        return check;
    }

    /**
     * Check the carIdNewType, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkCarIdNewType(String carNewId) {

        Pattern pat = Pattern.compile("[A-Z]{3}+[0-9]{3}");
        Matcher mat = pat.matcher(carNewId);
        check = mat.matches();
        return check;
    }

    /**
     * Check the car color, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkColor(String color) {

        Pattern pat = Pattern.compile("[a-zA-Z]{0,15}");
        Matcher mat = pat.matcher(color);
        check = mat.matches();
        return check;
    }

    /**
     * Check the description, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkDescription(String description) {

        Pattern pat = Pattern.compile("[a-zA-Z\\s]{0,200}");
        Matcher mat = pat.matcher(description);
        check = mat.matches();
        return check;
    }

    /**
     * Check the car id, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkCarId(String carId) {
        if (checkCarIdOldType(carId) || checkCarIdNewType(carId)) {
            return true;
        } else {
            return true;
        }
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

}
