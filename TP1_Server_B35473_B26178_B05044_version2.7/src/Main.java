
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.DateFormatString;
import models.UserModel;
import usersBuilder.ConcreteBuilderCreateUser;
import usersBuilder.CustomException;
import usersBuilder.Director;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ana Teresa
 */
public class Main {

    public static void main(String[] args) {
        try {
            Director director = new Director();
            UserModel modelUser = new UserModel();
            Calendar cal = FormatDates.DateFormatString.getCalendarFormat("12/09/1994");
            director.createUser(new ConcreteBuilderCreateUser(), modelUser, "207440123", "Edgardo Quiros", "edgardo.quiros@ucrso.info", "Edgardo123", cal, "89767552");
            modelUser.createModel();
            modelUser.save();
            
            modelUser.listLoader();
           UserModel.getUserListManager().getUser(0);
            
            
            
        } catch (CustomException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
