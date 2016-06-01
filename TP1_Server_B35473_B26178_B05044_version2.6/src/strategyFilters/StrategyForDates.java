package strategyFilters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import objectLists.SaleList;
import models.SaleModel;
import usersBuilder.CustomException;

/**
 * Class that implements Strategy and define method to create a new list
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class StrategyForDates implements Strategy {

    /**
     * this method create a new list with the Sales between two dates
     *
     * @param parameter, the dates for decides de new list
     * @return list with the sales between the dates
     */
    @Override
    public ArrayList<SaleModel> order(Object... parameter) {

        ArrayList<Date> fechas = new ArrayList<>();
        for (Object i : parameter) {
            fechas.add((Date) i);
        }
        ArrayList<SaleModel> filtradas = new ArrayList<>();
        SaleList original = new SaleList();
        List<SaleModel> allSales = new ArrayList<>();
        allSales.addAll(original.getActiveList());
        allSales.addAll(original.getApproveSalesList());
        allSales.addAll(original.getNextSalesList());
        allSales.addAll(original.getWaitingApproveSalesList());
        
        for (int i = 0; i < allSales.size(); i++) {
            if (allSales.get(i).getInitialDate().after(fechas.get(0))
                    && allSales.get(i).getInitialDate().before(fechas.get(1))) {
                filtradas.add(allSales.get(i));
            }
            if (filtradas.isEmpty()) {
                try {
                    throw new CustomException("No hay subastas dentro del rango de fechas establecido");
                } catch (CustomException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        filtradas.sort(new orderForDate());
        return filtradas;
    }

    /**
     * private class that implements Comparator and defines methods to create a
     * user
     */
    private class orderForDate implements Comparator<SaleModel> {

        /**
         * this method compare two SaleModel with the initialDate
         *
         * @param o1, the first SaleModel for comparation
         * @param o2, the second SaleModel for comparation
         *
         * @return the result for the comparation
         */
        @Override
        public int compare(SaleModel o1, SaleModel o2) {
            if (o1.getInitialDate().after(o2.getInitialDate())) {
                return 1;
            } else if (o1.getInitialDate().equals(o2.getInitialDate())) {
                return 0;
            } else {
                return -1;
            }

        }
    }
}
