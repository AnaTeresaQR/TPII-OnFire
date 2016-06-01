package factorySale;

import models.SaleModel;

/**
 * Creat a close sale object.
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada
 */
public class OpenSale extends SaleModel {

    public OpenSale() {
    }

    @Override
    public String toString() {
        return "SaleOpen{" + super.toString() + " maxOffer: " + getMaxOffer() + '}';
    }

}
