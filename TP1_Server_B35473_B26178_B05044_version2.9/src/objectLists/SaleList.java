package objectLists;

import strategyFilters.Strategy;
import enums.EnumFiles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

    private List<List> saleList;
    private Strategy strategy;

    private List<SaleModel> approveSalesList;
    private List<SaleModel> waitingApproveSalesList;
    private List<SaleModel> activeList;
    private List<SaleModel> nextSalesList;

    private final String APPROVE = "approve";
    private final String WAITING = "waiting";
    private final String ACTIVE = "active";
    private final String NEXT = "next";

    public SaleList() {
        saleList = new ArrayList<>();
        approveSalesList = new ArrayList<>();
        waitingApproveSalesList = new ArrayList<>();
        nextSalesList = new ArrayList<>();
        activeList = new ArrayList<>();

    }

    public boolean addSale(SaleModel sale) throws CustomException {
        switch (sale.getState()) {
            case APPROVE:
                if (!approveSalesList.contains(sale)) {
                    return this.approveSalesList.add(sale);
                }
                return false;
            case WAITING:
                if (!waitingApproveSalesList.contains(sale)) {
                    return this.waitingApproveSalesList.add(sale);
                }
                return false;

            case ACTIVE:
                if (!activeList.contains(sale)) {
                    return this.activeList.add(sale);
                }
                return false;

            case NEXT:
                if (!nextSalesList.contains(sale)) {
                    return this.nextSalesList.add(sale);
                }
                return false;

            default:
                return false;
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
        ListLoader<List> loader = new ListLoader<>(EnumFiles.SALE_FILE_NAME.getValue());

        saleList = (List<List>) loader.loadList();

        if (!saleList.isEmpty() && saleList.size() == 4) {
            this.approveSalesList = (List<SaleModel>)saleList.get(0);
            this.waitingApproveSalesList = (List<SaleModel>)saleList.get(1);
            this.activeList = (List<SaleModel>)saleList.get(2);
            this.nextSalesList = (List<SaleModel>)saleList.get(3);
        }
    }

    /**
     * Save the list in the binary file
     */
    public void save() {
        ListSaver<List> save = new ListSaver<>(EnumFiles.SALE_FILE_NAME.getValue());
        reLoad();
        
        System.out.println(print());
        
        save.saveList(saleList);
    }

    private void reLoad() {

        saleList = new ArrayList<>();
        
        saleList.add(approveSalesList);
        saleList.add(waitingApproveSalesList);
        saleList.add(activeList);
        saleList.add(nextSalesList);

    }
    
    public  String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < saleList.size(); i++) {
            List<SaleModel> x = saleList.get(i);
            sb.append("Inicio Lista: " + i + "\n");
            for (int j = 0; j < x.size(); j++) {
                sb.append(x.get(j).getCarId());
                sb.append("\n");
            }
            sb.append("Fin Lista: " + i + "\n");
        }
        
        return sb.toString();
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

    public int totalSize() {
        int size = 0;
        for (List t : saleList) {
            size += t.size();
        }

        return size;
    }
    
    public Map<String, String> getSales(String email){
        Map<String, String> map = new TreeMap<>();
        for(List<SaleModel> temp: saleList){
            for(SaleModel model: temp){
                
                if (model.getUser().getEmail().equals(email)) {
                    map.put(model.getCarId(), model.toString());
                    
                }
            }
        }
        
        return map;
    }

}
