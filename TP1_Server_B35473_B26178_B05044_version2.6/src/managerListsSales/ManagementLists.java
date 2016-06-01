package managerListsSales;

import java.util.ArrayList;
import java.util.List;
import models.SaleModel;

/**
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class ManagementLists {

    private List<SaleModel> approveSalesList;
    private List<SaleModel> waitingApproveSalesList;
    private List<SaleModel> activeList;
    private List<SaleModel> nextSalesList;

    private final String APPROVE = "approve";
    private final String WAITING = "waiting";
    private final String ACTIVE = "active";
    private final String NEXT = "next";

    public ManagementLists() {
        this.approveSalesList = new ArrayList<>();
        this.waitingApproveSalesList = new ArrayList<>();
        this.activeList = new ArrayList<>();
        this.nextSalesList = new ArrayList<>();

    }

    public boolean addSale(SaleModel sale) throws Exception {
        switch (sale.getState()) {
            case APPROVE:
                return this.approveSalesList.add(sale);
            case WAITING:
                return this.waitingApproveSalesList.add(sale);
            case ACTIVE:
                return this.activeList.add(sale);
            case NEXT:
                return this.nextSalesList.add(sale);
            default:
                throw new Exception("La subasta no tiene un estado correcto y no se pudo agregar");
        }

    }

    public boolean removeSale(SaleModel sale) throws Exception {
        switch (sale.getState()) {
            case APPROVE:
                return this.approveSalesList.remove(sale);
            case WAITING:
                return this.waitingApproveSalesList.remove(sale);
            case ACTIVE:
                return this.activeList.remove(sale);
            case NEXT:
                return this.nextSalesList.remove(sale);
            default:
                throw new Exception("La subasta no tiene un estado correcto y no se pudo eliminar");
        }

    }

    public boolean updateSale(SaleModel sale, SaleModel newSale) throws Exception {
        switch (sale.getState()) {
            case APPROVE:
                if (approveSalesList.contains(sale)) {
                    int index = approveSalesList.indexOf(sale);
                    approveSalesList.set(index, newSale);
                    return true;
                }
            case WAITING:
                if (waitingApproveSalesList.contains(sale)) {
                    int index = waitingApproveSalesList.indexOf(sale);
                    waitingApproveSalesList.set(index, newSale);
                    return true;
                }
            case ACTIVE:
                if (activeList.contains(sale)) {
                    int index = activeList.indexOf(sale);
                    activeList.set(index, newSale);
                    return true;
                }
            case NEXT:
                if (nextSalesList.contains(sale)) {
                    int index = nextSalesList.indexOf(sale);
                    nextSalesList.set(index, newSale);
                    return true;
                }
            default:
                throw new Exception("La subasta no tiene un estado correcto");
        }

    }

    public boolean changeState(SaleModel sale, String newState) throws Exception {
        switch (sale.getState()) {
            case APPROVE:
                removeSale(sale);
                sale.setState(newState);
                return addSale(sale);
            case WAITING:
                removeSale(sale);
                sale.setState(newState);
                return addSale(sale);
            case ACTIVE:
                removeSale(sale);
                sale.setState(newState);
                return addSale(sale);
            case NEXT:
                removeSale(sale);
                sale.setState(newState);
                return addSale(sale);
            default:
                throw new Exception("La subasta no tiene un estado correcto y no se pudo cambiar el estado");
        }

    }

    public SaleModel readSale(SaleModel sale) throws Exception {
        int index;
        switch (sale.getState()) {
            case APPROVE:
                index = approveSalesList.indexOf(sale);
                return approveSalesList.get(index);
            case WAITING:
                index = waitingApproveSalesList.indexOf(sale);
                return waitingApproveSalesList.get(index);
            case ACTIVE:
                index = activeList.indexOf(sale);
                return activeList.get(index);
            case NEXT:
                index = nextSalesList.indexOf(sale);
                return nextSalesList.get(index);
            default:
                throw new Exception("La subasta no fue encontrada");
        }

    }

    public List<SaleModel> getApproveSalesList() {
        return approveSalesList;
    }

    public List<SaleModel> getWaitingApproveSalesList() {
        return waitingApproveSalesList;
    }

    public List<SaleModel> getActiveList() {
        return activeList;
    }

    public List<SaleModel> getNextSalesList() {
        return nextSalesList;
    }

}
