package strategyFilters;

import java.util.ArrayList;
import models.SaleModel;

/**
 * interface that contains the declaration of the method for create new list 
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public interface Strategy {

    public ArrayList<SaleModel> order(Object... parametro);
}
