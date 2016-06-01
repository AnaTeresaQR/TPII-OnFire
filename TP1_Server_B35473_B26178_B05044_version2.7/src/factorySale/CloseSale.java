package factorySale;

import models.SaleModel;

/**
 * Creat a close sale object.
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada
 */
public class CloseSale extends SaleModel {

    public CloseSale() {
    }

    @Override
    public String toString() {
        return "SaleClose{" + super.toString() + " maxOffer: " + getMaxOffer() + '}';
    }

}
