package usersBuilder;

import java.util.Calendar;
import models.UserModel;

/**
 * interface that contains the declaration of the methods needed to build parts
 * of a user
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public interface AbstractBuilderCreateUser {

    public void buildUser(UserModel user);

    public void buildId(String id) throws CustomException;

    public void buildName(String name) throws CustomException;

    public void buildEmail(String email) throws CustomException;

    public void buildPassword(String password) throws CustomException;

    public void buildBirthdate(Calendar birthday) throws CustomException;

    public void buildPhoneNumber(String phoneNumber) throws CustomException;

    public UserModel getUser() throws CustomException;

}
