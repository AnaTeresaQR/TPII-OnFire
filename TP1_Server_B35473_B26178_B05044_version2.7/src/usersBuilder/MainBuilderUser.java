package usersBuilder;

import factorySale.ConcreteFactorySale;
import factorySale.FactorySaleInterface;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import salesBuilder.AbstractBuilderCreateSale;
import salesBuilder.DirectorSales;
import salesBuilder.ConcreteBuilderOpenSale;
import models.UserModel;
import models.SaleModel;

/**
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class MainBuilderUser {

    public static void main(String[] args) {

//        AbstractBuilderCreateUser abs = null;
//
//        Director director = new Director();
//
//        AbstractBuilderCreateSale abSale = null;
//
//        DirectorSales directorSales = new DirectorSales();
//
//        SaleModel sale;
//
//        try {
//         //   UserModel user1 = director.createUser(abs, "206780357", "Chester", "chester112@gmail.com", "123456A", new GregorianCalendar(1995, 6, 29), "88888888");
//
//            FactorySaleInterface factory = new ConcreteFactorySale();
//
////            SaleModel sale1 = factory.createSale(new ConcreteBuilderOpenSale(), sale, new Date(1, 10, 200), user1, "toyota", "prado33", 2000, "abs-123", "blanco", "ssddd sccc cccc", 4, 10000000);
//            //    System.out.println(sale1);
////            System.out.println(sale1.toString());
////            Sale sale = directorSales.createSale(abSale, new Date(1, 10, 200), user1, "toyota", "prado33", 2000, "abs-123", "blanco", "ssddd sccc cccc", 4, 10000000);
////            Sale subasta = new CloseSale();
////
////            ((CloseSale) subasta).addOffer(new Offer(1000, user1));
////            ((CloseSale) subasta).addOffer(new Offer(2000, user1));
////            System.out.println(((CloseSale) subasta).getMaxOffer());
////
////            System.out.println(sale.toString());
////        } catch (CustomException ex) {
////            Logger.getLogger(MainBuilderUser.class.getName()).log(Level.SEVERE, null, ex);
////        }
    }

}
