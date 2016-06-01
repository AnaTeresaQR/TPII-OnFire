package models;

/**
 * Class contains the UserMosdel and its offer of a sale
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class Offer {

    private int offer;
    private UserModel user;

    public Offer(int offer, UserModel user) {
        this.offer = offer;
        this.user = user;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Offer{" + "offer: " + offer + ", user: " + user + '}';
    }

}
