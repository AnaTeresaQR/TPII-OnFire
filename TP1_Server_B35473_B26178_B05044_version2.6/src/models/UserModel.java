package models;

import java.io.Serializable;
import java.util.Calendar;
import objectLists.UsersList;
import usersBuilder.CustomException;

/**
 * The user object with its data, get and set
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class UserModel extends DateFormatString implements Serializable {

    private String id; // user shcedule
    private String name; // user name
    private String email; // user email
    private String password; // user email password
    private Calendar birthdate; // user birthdate
    private String phoneNumber; // user phoneNumber
    private String notificationsMyownSales;// String of notifications
    private String notificationsOtherSales; // String of notifications

    private static final UsersList userListManager = new UsersList();

    public UserModel() {
        this.notificationsMyownSales = "";
        this.notificationsOtherSales = "";
    }

    public UserModel(String id, String name, String email, String password, Calendar birthdate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;

    }

    /**
     * Method to get the users list.
     *
     * @return sales list.
     */
    public static UsersList getUserListManager() {
        return userListManager;
    }

    /**
     * Method to add the user model to the users list.
     */
    public boolean createModel() {
        return userListManager.register(this);
    }

    /**
     * Method to get the user model from the users list.
     *
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public static UserModel findModel(int index) throws ArrayIndexOutOfBoundsException {
        return userListManager.getUser(index);
    }

    public void save() {
        userListManager.save();
    }

    public void listLoader() {
        userListManager.listLoader();
    }

    public void refresh() {
        userListManager.refresh();
    }

    public UserModel login(String email, String password) {
        return userListManager.login(email, password);
    }

    /**
     * Contains the size of the list
     *
     * @return the size of the list
     */
    public int size() {
        return userListManager.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method used for send a notification to user that a Sale has been approved
     * or disapproved.
     *
     * @param sale Sale approved or disapproved;
     * @param reasonForDisapprove Reason for disaprove a sale.
     */
    public void updateApproveSale(SaleModel sale, String reasonForDisapprove) {
        if (sale.isSaleApproved()) {
            this.notificationsMyownSales += "La subasta del vehículo placa: " + sale.getCarId()
                    + ", ha sido aceptada. El costo de su subasta es: " + sale.calculateCost()
                    + " colones, e inicia el dia: " + sale.getDateFormat(sale.getInitialDate()) + "\n";
        } else {
            this.notificationsMyownSales += "Subasta rechaza por el siguiente motivo: " + reasonForDisapprove + "\n";
        }
    }

    /**
     * Method used for send a notification to user that a Sale has been deleted.
     *
     * @param sale Sale deleted;
     * @param reasonForDelete Reason for delete a sale.
     */
    public void updateDeleteSale(SaleModel sale, String reasonForDelete) {
        this.notificationsMyownSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha sido eliminada por el siguiente motivo: " + reasonForDelete + "\n";
        this.notificationsOtherSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha sido eliminada por el siguiente motivo: " + reasonForDelete + "\n";
    }

    /**
     * Method used for send a notification to user that a Sale has been
     * activated.
     *
     * @param sale Sale activated.
     */
    public void updateActivateSale(SaleModel sale) {
        this.notificationsMyownSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha sido  activada" + "\n";
    }

    /**
     * Method used for send a notification to user that a Sale has been
     * initiated.
     *
     * @param sale Sale initiated.
     */
    public void updateStartSale(SaleModel sale) {
        this.notificationsMyownSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha llegado a su fecha de inicio" + "\n";
    }

    /**
     * Method used for send a notification to user that a Sale has been
     * initiated and not been paid.
     *
     * @param sale Sale initiated and not paid.
     */
    public void updateStartSaleNoPaid(SaleModel sale) {
        this.notificationsMyownSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha llegado a su fecha de inicio y aún no ha sido pagada" + "\n";
    }

    /**
     * Method used for send a notification to user that a Sale has been
     * finalized.
     *
     * @param sale Sale finalized.
     */
    public void updateEndSale(SaleModel sale) {
        this.notificationsMyownSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha sido finalizada. El monto ganador fue: " + sale.getMaxOffer().getOffer()
                + ". Debe cancelar el siguiente monto: " + sale.calculateCostEndSale() + "\n";
    }

    /**
     * Method used for send a notification to user that a Sale has been
     * finalized and he has been the winner.
     *
     * @param sale Sale finalized.
     */
    public void updateUserWinner(SaleModel sale) {
        this.notificationsOtherSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha sido finalizada y usted la ha ganado. El monto a cancelar es: " + sale.getMaxOffer().getOffer() + "\n";
    }

    /**
     * Method used for send a notification to user that a Sale has been
     * finalized and he has not been the winner.
     *
     * @param sale Sale finalized.
     */
    public void updateUserLooser(SaleModel sale) {
        this.notificationsOtherSales += "La subasta del vehículo placa: " + sale.getCarId()
                + ", ha sido finalizada y usted no la ha ganado."
                + "El monto ganador fue: " + sale.getMaxOffer().getOffer() + "\n";
    }

    public String getNotificationsMyownSales() {
        return notificationsMyownSales;
    }

    public String getNotificationsOtherSales() {
        return notificationsOtherSales;
    }

    @Override
    public String toString() {
        return "\nUsuario{ " + "Schedule: " + id + ", name: " + name + "\nemail: " + email + ", password: " + password + ", birthdate: " + getDateFormat(birthdate.getTime()) + ", phoneNumber: " + phoneNumber + '}';
    }

}
