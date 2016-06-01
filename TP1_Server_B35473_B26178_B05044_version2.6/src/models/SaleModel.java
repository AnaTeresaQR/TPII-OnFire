package models;

import factorySale.ManagerOffersOpenCloseSale;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import objectLists.SaleList;
import usersBuilder.CustomException;

/**
 * The sale object with its data, get and set
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class SaleModel extends DateFormatString {

    private Date initialDate;
    private UserModel user;
    private String brand;
    private String model;
    private int year;
    private String carId;
    private String color;
    private String description;
    private int days;
    private int minOffer;
    private boolean saleApproved;
    private String registrationDate;
    private String state;

    private final int INITIALPAYMENTAMOUT = 5000;

    private static final SaleList saleListManager = new SaleList();
    private static ManagerOffersOpenCloseSale manager;

    public SaleModel() {
    }

    public SaleModel(UserModel user, String brand, String model, int year, String carId, String color, String description, int days, int minOffer) {
        this.user = user;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carId = carId;
        this.color = color;
        this.description = description;
        this.days = days;
        this.minOffer = minOffer;
        manager = new ManagerOffersOpenCloseSale();
    }

    public static SaleList getSaleListManager() {
        return saleListManager;
    }

    public boolean createModel() throws CustomException {
        return saleListManager.addSale(this);
    }

    public static SaleModel findModel(SaleModel index) throws ArrayIndexOutOfBoundsException, CustomException {
        return saleListManager.readSale(index);
    }

    public boolean delete() throws CustomException {
        return saleListManager.removeSale(this);
    }

    public void save() throws CustomException {
        this.setState("waiting");
        saleListManager.addSale(this);
        System.out.println("tamaño de la lista de espera" + saleListManager.getWaitingApproveSalesList().size());
        saleListManager.save();
    }

    public void listLoader() {
        saleListManager.listLoader();
    }

    public void refresh() {
        saleListManager.refresh();
    }

    /**
     * Method that define calculate the initial cost of a sale
     *
     * @return initial cost of a sale
     */
    public int calculateCost() {
        return INITIALPAYMENTAMOUT * getDays();
    }

    /**
     * Method that define calculate the cost of a ended sale
     *
     * @return cost of a ended sale
     */
    public double calculateCostEndSale() {
        double endCost = getMaxOffer().getOffer() * 0.10;
        return endCost;
    }

    /**
     * Method that define calculate the highest offer
     *
     * @return the highest offer
     */
    public static Offer getMaxOffer() {
        return manager.getMaxOffer();
    }

    /**
     * Method that define add a offer in the offers list
     *
     * @param offer offer to add in the offers list
     * @return if the offer has been added in the offers list or not-
     */
    public static boolean addOffer(Offer offer) {
        return manager.addOffer(offer);
    }

    /**
     * Method to register the date of a sale.
     *
     * @return the registration date.
     */
    public String getRegistrationDate() {
        Calendar fecha = new GregorianCalendar();
        int anno = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        this.registrationDate = dia + mes + anno + "";
        return registrationDate;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date date) {
        this.initialDate = date;
    }

    public boolean isSaleApproved() {
        return saleApproved;
    }

    public void setSaleApproved(boolean isSaleApproved) {
        this.saleApproved = isSaleApproved;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getMinOffer() {
        return minOffer;
    }

    public void setMinOffer(int minOffer) {
        this.minOffer = minOffer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Marca: " + brand + "\nModelo: " + model + "\nAño: " + year + "\nNúmero de placa: " + carId + "\nColor: " + color + "\nDescripción: " + description + "\nDuración de la subasta: " + days + " días" + "\nOferta mínima: " + minOffer + " colones";
    }

}
