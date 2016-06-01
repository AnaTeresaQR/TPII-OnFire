package strategyFilters;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import objectLists.SaleList;

/**
 *
 * @author Edgardo Quirós
 */
public class MainStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//     User user = new User("402090984", "edgardo", "edgardo@gmail.com", "123", new GregorianCalendar(13, 3, 1991), "89265194");
//        User user1 = new User("202090984", "edgardo", "edgardo@gmail.com", "123", new GregorianCalendar(13, 3, 1991), "89265194");
//        Sale sale1 = new Sale(new Date(1, 1, 110), user1, "toyota", "prado", 2000, "bvv-123", "azul", "", 4, 2000000);
//        Sale sale2 = new Sale(new Date(1, 1, 110), user, "nissan", "sado", 2000, "bvv-144", "negro", "", 4, 2000000);
//        Sale sale3 = new Sale(new Date(1, 1, 110), user, "ssss", "ssss", 2000, "bvv-155", "blanco", "", 4, 2000000);
        SaleList original = new SaleList();
//      original.addSale(sale1);
//       original.addSale(sale2);
//       original.addSale(sale3);

        SaleList original1 = new SaleList();

        Strategy stra = new StrategForBrand();
        original.setStrategy(stra);
        //  ArrayList list=stra.ordenar("toyota");
        // System.out.println(list.size());

        Date fecha1 = new Date(1, 1, 110);
        Date fecha2 = new Date(11, 11, 110);
        Date fecha3 = new Date(11, 11, 110);

    }

}
