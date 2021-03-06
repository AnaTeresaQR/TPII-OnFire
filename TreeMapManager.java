package exercise3;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class that contains methods of the program
 *
 * @author Ana Teresa
 *
 */
public class TreeMapManager {

    private Map<String, String> treeMap;

    public TreeMapManager(TreeMap<String, String> tmap) {
        this.treeMap = new TreeMap<>();
    }

    /**
     * Method that adds items to the Map
     *
     * @param key
     * @param value
     */
    public void add(String key, String value) {
        if (!search(key) && !treeMap.containsKey(key)) { //car id and Id must be different to add
            treeMap.put(key, value);
        }
    }

    /**
     * Method that eliminate items to the queue
     *
     * @param id, receives the id to eliminate the key and the full sale
     */
    public void eliminate(String id) {
        treeMap.remove(id);
    }

    /**
     * Method that print the queue
     *
     * @return a String with the ArrayList
     */
    public String print() {
        String message = "";
        Iterator< Integer> iterator;
        List list = new ArrayList(treeMap.values());
        iterator = list.iterator();
        while (iterator.hasNext()) {
            message += iterator.next() + "\n";
        }
        return message;
    }

    /**
     * Method that chech if the car is already in the queue
     *
     * @param key, receives the number
     * @return true if number of car id already in queue
     */
    public boolean search(String key) {
        Iterator<String> iterator;
        Set<String> set = treeMap.keySet();
        iterator = set.iterator();
        while (iterator.hasNext()) {
            String key2 = treeMap.get(iterator.next());

            if (key.equals(key2)) {
                return true;
            }
        }
        return false;
    }

    
}
