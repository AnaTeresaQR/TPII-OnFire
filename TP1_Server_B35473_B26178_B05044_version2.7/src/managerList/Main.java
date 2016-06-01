package managerList;

import java.util.GregorianCalendar;
import models.UserModel;
import objectLists.UsersList;
import usersBuilder.ConcreteBuilderCreateUser;
import usersBuilder.CustomException;
import usersBuilder.Director;

/**
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class Main {

    public static void main(String[] args) throws CustomException {

//        AbstractBuilderCreateUser abs = null;
//
//        Director director = new Director();
//
//        UserModel user3 = director.createUser(abs, "201740170", "AnaTeresa", "ana.quesada@ucrso.info", "ana123", new GregorianCalendar(1995, 9, 9), "84590688");
//        UsersList userList = UsersList.getUniqueInstance();
//        // save the list
//        userList.register(user3); // register an user
//        userList.save();
//        // refresh
//        userList.refresh();
//
////        System.out.println(userList.getIndex(0));
//        System.out.println("Login user: " + userList.login("ana.quesada@ucrso.info", "ana123")); // login a user
        //--------------------------------------------------------------------------------------
//        UsersList userList = new UsersList();
//        userList.listLoader();
//        UserModel user = new UserModel("201740170", "AnaTeresa", "ana.quesada@ucrso.info", "ana123", new GregorianCalendar(1995, 9, 9), "84590688");
//        userList.register(user);
//        userList.save();
//        userList = new UsersList();
//        userList.listLoader();
//        System.out.println("Cantidad: " + userList.size());
//        System.out.println("Login user: " + userList.login("ana.quesada@ucrso.info", "ana123"));
        Director director = new Director();
        UserModel userM = new UserModel();
        userM.listLoader();
//        director.createUser(new ConcreteBuilderCreateUser(), userM, "201740170", "AnaTeresa", "ana.quesada@ucrso.info", "ana123", new GregorianCalendar(1995, 9, 9), "84590688");
//        userM.createModel(); // register
//        userM.save();
        userM = new UserModel();
        userM.listLoader();
        System.out.println("" + userM.size());
        System.out.println("Login user: " + userM.login("robert.sanchez@ucrso.info", "Robert123"));
    }

}
