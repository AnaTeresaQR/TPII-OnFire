package observerApproveSale;

import factorySale.CloseSale;
import factorySale.ManagerOffersOpenCloseSale;
import factorySale.OpenSale;
import java.util.List;
import models.SaleModel;
import models.UserModel;

/**
 *
 * @author robert
 */
public class Sale_ObservableX implements Sale_Observable {

    private final ManagerOffersOpenCloseSale managerOpenCloseList;
    private final List<UserModel> offerNotify;

    public Sale_ObservableX() {
        managerOpenCloseList = new ManagerOffersOpenCloseSale();
        offerNotify = managerOpenCloseList.getOfferUsers();
    }

    @Override
    public void sendNotifyApproveSale(SaleModel sale, String reasonForDisapprove) {
        sale.getUser().updateApproveSale(sale, reasonForDisapprove);
    }

    @Override
    public void sendNotifyDeleteSale(SaleModel sale, String reasonForDelete) {
        notifyDelete(sale, reasonForDelete);
    }

    @Override
    public void sendNotifyActivateSale(SaleModel sale) {
        sale.getUser().updateActivateSale(sale);
    }

    @Override
    public void sendNotifyStartSale(SaleModel sale) {
        sale.getUser().updateStartSale(sale);
    }

    @Override
    public void sendNotifyStartSaleNoPaid(SaleModel sale) {
        sale.getUser().updateStartSaleNoPaid(sale);
    }

    @Override
    public void sendNotifyEndSale(SaleModel sale) {
        notifyEndSale(sale);
    }

    private void notifyDelete(SaleModel sale, String reasonForDelete) {
        sale.getUser().updateDeleteSale(sale, reasonForDelete);
        if (sale instanceof OpenSale) {
            for (UserModel tempUser : offerNotify) {
                tempUser.updateDeleteSale(sale, reasonForDelete);
            }
        } else {
            if (sale instanceof CloseSale) {
                for (UserModel tempUser : offerNotify) {
                    tempUser.updateDeleteSale(sale, reasonForDelete);
                }
            }
        }
    }

    private void notifyEndSale(SaleModel endSale) {
        endSale.getUser().updateEndSale(endSale);
        notifyWinnerOrLose(endSale);

    }

    private void notifyWinnerOrLose(SaleModel endSale) {
        for (UserModel tempUser : offerNotify) {
            if (tempUser.getId().equals(managerOpenCloseList.getUserMaxOffer())) {
                endSale.getUser().updateUserWinner(endSale);
            } else {
                endSale.getUser().updateUserLooser(endSale);
            }
        }
    }

}
