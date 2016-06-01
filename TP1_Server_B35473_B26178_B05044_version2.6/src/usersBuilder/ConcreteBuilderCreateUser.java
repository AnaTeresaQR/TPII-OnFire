package usersBuilder;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.UserModel;

/**
 * Class that implements AbstractBuilderCreateUser and defines methods to create
 * a user
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class ConcreteBuilderCreateUser implements AbstractBuilderCreateUser {

    private UserModel user;
    private boolean check;

    /**
     * Class constructor
     */
    public ConcreteBuilderCreateUser() {
    }

    /**
     * Returns a user if all parts have been validated with regular expressions
     *
     * @return @throws CustomException if any parts could not be created
     * correctly
     */
    @Override
    public UserModel getUser() throws CustomException {
        return user;

    }

    @Override
    public void buildUser(UserModel user) {
        this.user = user;
    }

    /**
     * Builds id if it is not empty or null
     *
     * @param id, the schedule of the user
     * @throws CustomException, if can not set the id
     */
    @Override
    public void buildId(String id) throws CustomException {
        if (id != null
                && !id.equals("")
                && checkId(id)) {
            user.setId(id);
        } else {
            throw new CustomException("Formato incorrecto de cédula, utilice el formato de cédula costarricense");

        }

    }

    /**
     * Builds name if it is not empty or null
     *
     * @param name, the name of the user
     * @throws CustomException, if can not set the name
     */
    @Override
    public void buildName(String name) throws CustomException {
        if (name != null
                && !name.equals("")
                && checkName(name)) {
            user.setName(name);

        } else {
            throw new CustomException("La extensión del nombre excede el tamaño permitido, debe ser menor a 100 caracteres.");
        }
    }

    /**
     * Builds email if it is not empty or null
     *
     * @param email, the email of the user
     * @throws CustomException if can not set themail
     */
    @Override
    public void buildEmail(String email) throws CustomException {
        if (email != null
                && !email.equals("")
                && checkEmail(email)) {
            user.setEmail(email);
        } else {
            throw new CustomException("Formato incorrecto de email, Ingrese de nuevo. Ejemplo: ejemplo1@ejemplo.com");
        }
    }

    /**
     * Builds password if it is not empty or null
     *
     * @param password, the email password of the user
     * @throws CustomException if can not set password
     */
    @Override
    public void buildPassword(String password) throws CustomException {
        if (password != null
                && !password.equals("")
                && checkPassword(password)) {
            user.setPassword(password);
        } else {
            throw new CustomException("Formato incorrecto de contraseña. Ingrese de nuevo, no debe contener caracteres especiales y debe tener una extensión mínima de 5 caracteres.");
        }
    }

    /**
     * Check birthday if it is not null or if the user is of age
     *
     * @param birthdate, receives the user birthdate
     * @throws CustomException if can not set the birthdate
     */
    @Override
    public void buildBirthdate(Calendar birthdate) throws CustomException {
        if (birthdate != null && validateAdult(birthdate)) {
            user.setBirthdate(birthdate);
        } else {
            throw new CustomException("No es posible guardar la fecha de nacimiento");
        }
    }

    /**
     * Builds phoneNumber if it is not empty or null
     *
     * @param phoneNumber, the phoneNumber of the user
     * @throws CustomException if can not set phoneNumber
     */
    @Override
    public void buildPhoneNumber(String phoneNumber) throws CustomException {
        if (phoneNumber != null
                && !phoneNumber.equals("")
                && checkPhoneNumber(phoneNumber)) {
            user.setPhoneNumber(phoneNumber);
        } else {
            throw new CustomException("Formato incorrecto de teléfono. Ingrese de nuevo, utilizar formato constarricense");
        }
    }

    /**
     * Check the name, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkName(String name) {

        Pattern pat = Pattern.compile("[a-zA-Z\\s]{0,100}");
        Matcher mat = pat.matcher(name);
        check = mat.matches();
        return check;
    }

    /**
     * Check the schedule or id, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkId(String id) {
        Pattern pat = Pattern.compile("[0-9]{9}");
        Matcher mat = pat.matcher(id);
        check = mat.matches();
        return check;
    }

    /**
     * Check the email, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkEmail(String email) {

        //  Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern pat = Pattern.compile("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher mat = pat.matcher(email);
        check = mat.find();
        return check;
    }

    /**
     * Check the password, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkPassword(String password) {
        Pattern pat = Pattern.compile("[a-zA-Z0-9]{5,}");
        Matcher mat = pat.matcher(password);
        check = mat.matches();
        return check;
    }

    /**
     * Check the phoneNumber, validation with regular expressions
     *
     * @return true if matches, false if not
     */
    private boolean checkPhoneNumber(String phoneNumber) {
        Pattern pat = Pattern.compile("[0-9]{8}");
        Matcher mat = pat.matcher(phoneNumber);
        check = mat.matches();
        return check;
    }

    /**
     * Validate if the user is an adult
     *
     * @param birthdate, receives the user birthdate
     * @return true if is an adult, false if not
     */
    private boolean validateAdult(Calendar birthdate) {
        Calendar actual = Calendar.getInstance();

        int year = actual.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
        int month = actual.get(Calendar.MONTH) - birthdate.get(Calendar.MONTH);
        int day = actual.get(Calendar.DAY_OF_MONTH) - birthdate.get(Calendar.DAY_OF_MONTH);
        if (day < 0) {
            if (month < 0) {
                year--;
            }
        }
        return year >= 18;
    }

}
