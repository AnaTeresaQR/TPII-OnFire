package observerApproveSale;

import models.SaleModel;

/**
 *
 * @author rosan
 */
public class ThreadApproveSale extends Thread {

    private boolean SaleApproved = false;
    private Sale_Observable observer = new Sale_ObservableX();
    private SaleModel sale;
    private String reasonForDisapprove;

    public Sale_Observable getObserver() {
        return observer;
    }

    public void setObserver(Sale_Observable observer) {
        this.observer = observer;
    }

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel Sale) {
        this.sale = Sale;
    }

    public String getReasonForDisaprove() {
        return reasonForDisapprove;
    }

    public void setReasonForDisaprove(String reasonForDisaprove) {
        this.reasonForDisapprove = reasonForDisaprove;
    }

    public boolean isSaleApproved() {
        return SaleApproved;
    }

    public void setSaleApproved(boolean SaleApproved) {
        this.SaleApproved = SaleApproved;
    }

    public void sendNotify() {
        observer.sendNotifyApproveSale(sale, reasonForDisapprove);
    }

    @Override
    public synchronized void run() {
        while (!SaleApproved) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        notify();//Donde colocar el notify???
        sendNotify();
        SaleApproved = false;

    }
}
