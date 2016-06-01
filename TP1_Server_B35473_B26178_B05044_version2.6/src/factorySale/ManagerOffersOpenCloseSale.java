package factorySale;

import java.util.ArrayList;
import java.util.List;
import models.Offer;
import models.UserModel;

/**
 * Class to manage the lists of open and close sales.
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada
 */
public class ManagerOffersOpenCloseSale {

    private List<Offer> offers;

    public ManagerOffersOpenCloseSale() {
        offers = new ArrayList<>();
    }

    /**
     * Add new offer.
     *
     * @param offer to add.
     * @return true if the offer has been added, false if not.
     */
    public boolean addOffer(Offer offer) {
        return offers.add(offer);
    }

    /**
     * Get the highest offer.
     *
     * @return the highest offer.
     */
    public Offer getMaxOffer() {
        offers.sort(new OrderOffers());
        return offers.get(0);
    }

    /**
     * Get the id user with the highest offer.
     *
     * @return the id user with the highest offer.
     */
    public String getUserMaxOffer() {
        UserModel maxOffer = getMaxOffer().getUser();
        String idUser = maxOffer.getId();
        return idUser;
    }

    /**
     * Get the users of sale offers list
     *
     * @return the users of sale offers list
     */
    public List<UserModel> getOfferUsers() {
        List<UserModel> users = new ArrayList<>();
        for (Offer openOffer : offers) {
            users.add(openOffer.getUser());
        }
        return users;
    }

}
