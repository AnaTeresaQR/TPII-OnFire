package factorySale;

import java.util.Comparator;
import models.Offer;

/**
 * Class to oder offer list by highest offer.
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class OrderOffers implements Comparator<Offer> {

    /**
     * Method to compare 2 offers.
     *
     * @param offer1 firs offer to compare.
     * @param offer2 second offer to compare.
     * @return the highest offer.
     */
    @Override
    public int compare(Offer offer1, Offer offer2) {
        if (offer1.getOffer() > offer2.getOffer()) {
            return -1;
        } else if (offer1.getOffer() == offer2.getOffer()) {
            return 0;
        }
        return 1;
    }

}
