package objectLists;

import strategyFilters.Strategy;
import enums.EnumFiles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import managerList.ListLoader;
import managerList.ListSaver;
import models.SaleModel;
import usersBuilder.CustomException;

/**
 * Class that is responsible for handling the sale list. Only this class can
 * create an instance of itself. Singleton pattern
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class SaleList implements Serializable {

    private List<SaleList> saleList;
    private Strategy strategy;

    public SaleList() {
        saleList = new ArrayList<>();
        listLoader();
    }

    private List<SaleModel> approveSalesList;
    private List<SaleModel> waitingApproveSalesList;
    private List<SaleModel> activeList;
    private List<SaleModel> nextSalesList;

    private final String APPROVE = "approve";
    private final String WAITING = "waiting";
    private final String ACTIVE = "active";
    private final String NEXT = "next";

    public boolean addSale(SaleModel sale) throws CustomException {
        switch (sale.getState()) {
            case APPROVE:
                if (!approveSalesList.contains(sale)) {
                    return this.approveSalesList.add(sale);
                }
                throw new CustomException("La subasta ya existe y no se pudo agregar");
            case WAITING:
                if (!waitingApproveSalesList.contains(sale)) {
                    return this.waitingApproveSalesList.add(sale);
                }
                throw new CustomException("La subasta ya existe y no se pudo agregar");

            case ACTIVE:
                if (!activeList.contains(sale)) {
                    return this.activeList.add(sale);
                }
                throw new CustomException("La subasta ya existe y no se pudo agregar");

            case NEXT:
                if (!nextSalesList.contains(sale)) {
                    return this.nextSalesList.add(sale);
                }
                throw new CustomException("La subasta ya existe y no se pudo agregar");

            default:
                throw new CustomException("La subasta no tiene un estado correcto y no se pudo agregar");
        }

    }

    public boolean removeSale(SaleModel sale) throws CustomException {
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
                throw new CustomException("La subasta no tiene un estado correcto y no se pudo eliminar");
        }

    }

    public boolean updateSale(SaleModel sale, SaleModel newSale) throws CustomException {
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
                throw new CustomException("La subasta no tiene un estado correcto");
        }

    }

    public boolean changeState(SaleModel sale, String newState) throws CustomException {
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
                throw new CustomException("La subasta no tiene un estado correcto y no se pudo cambiar el estado");
        }

    }

    public SaleModel readSale(SaleModel sale) throws CustomException {
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
                throw new CustomException("La subasta no fue encontrada");
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

    /**
     * Refreshes the list if new sales are added
     */
    public void refresh() {
        saleList.clear();
        listLoader();
    }

    /**
     * Load the list with file elements
     */
    public void listLoader() {
        ListLoader<SaleList> loader = new ListLoader<>(EnumFiles.SALE_FILE_NAME.getValue());
        this.saleList = (List<SaleList>) loader.loadList();
    }

    /**
     * Save the list in the binary file
     */
    public void save() {
        ListSaver<SaleList> save = new ListSaver<>(EnumFiles.SALE_FILE_NAME.getValue());
        save.saveList((SaleList) this.saleList);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setActiveList(List<SaleModel> activeList) {
        this.activeList = activeList;
    }

    public void setApproveSalesList(List<SaleModel> approveSalesList) {
        this.approveSalesList = approveSalesList;
    }

    public void setNextSalesList(List<SaleModel> nextSalesList) {
        this.nextSalesList = nextSalesList;
    }

    public void setWaitingApproveSalesList(List<SaleModel> waitingApproveSalesList) {
        this.waitingApproveSalesList = waitingApproveSalesList;
    }

}
