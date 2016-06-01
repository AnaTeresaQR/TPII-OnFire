package strategyFilters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import objectLists.SaleList;
import models.SaleModel;
import usersBuilder.CustomException;

/**
 * Class that implements Strategy and define method to create a new list
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class StrategForBrand implements Strategy {

    /**
     * this method create a new list with the Sales between two dates
     *
     * @param parameter, the brand for decides de new list
     * @return list with the sales for the user with that id
     */

    @Override
    public ArrayList<SaleModel> order(Object... parameter) {
        ArrayList<String> received = new ArrayList<>();
        for (Object i : parameter) {
            received.add((String) i);
        }

        ArrayList<SaleModel> filtradas = new ArrayList<>();
        SaleList original = new SaleList();
        List<SaleModel> allSales = new ArrayList<>();
        allSales.addAll(original.getActiveList());
        allSales.addAll(original.getApproveSalesList());
        allSales.addAll(original.getNextSalesList());
        allSales.addAll(original.getWaitingApproveSalesList());
        String comparator = received.get(0);
        for (int i = 0; i < allSales.size(); i++) {
            System.out.println(allSales.get(i).getBrand());
            if (allSales.get(i).getBrand().equals(comparator)) {
                filtradas.add(allSales.get(i));
            }
        }
        if (filtradas.isEmpty()) {
            try {
                throw new CustomException("No hay subastas para esta marca establecida");
            } catch (CustomException ex) {
                System.out.println(ex.getMessage());
            }
        }
        filtradas.sort(new OrderForBrand());
        return filtradas;

    }

    /**
     * private class that implements Comparator and defines methods to create a
     * user
     */
    private class OrderForBrand implements Comparator<SaleModel> {

        /**
         * this method compare two SaleModel with the brand
         *
         * @param o1, the first SaleModel for comparation
         * @param o2, the second SaleModel for comparation
         *
         * @return the result for the comparation
         */

        @Override
        public int compare(SaleModel o1, SaleModel o2) {
            return o1.getBrand().compareTo(o2.getBrand());
        }

    }
}
