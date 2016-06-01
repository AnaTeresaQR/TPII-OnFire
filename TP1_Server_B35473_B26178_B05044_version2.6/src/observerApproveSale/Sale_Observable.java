package observerApproveSale;

import models.SaleModel;

/**
 *
 * @author robert
 */
public interface Sale_Observable {

    public void sendNotifyApproveSale(SaleModel sale, String reasonForDisapprove);

    public void sendNotifyDeleteSale(SaleModel sale, String reasonForDelete);

    public void sendNotifyActivateSale(SaleModel sale);

    public void sendNotifyStartSale(SaleModel sale);

    public void sendNotifyStartSaleNoPaid(SaleModel sale);

    public void sendNotifyEndSale(SaleModel sale);

}
