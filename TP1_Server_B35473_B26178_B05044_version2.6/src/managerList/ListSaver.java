package managerList;

import files.FileWriter;
import java.io.IOException;
import java.util.List;
import objectLists.SaleList;

/**
 * Class writes the list stored in the collection in a binary file
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 * @param <T> the object that will be save in the list
 */
public class ListSaver<T> {

    private final FileWriter<T> fileWriter;

    public ListSaver(String fileName) {
        fileWriter = new FileWriter<>(fileName);
    }

    /**
     * Method loops through the list and is responsible for storing each item in
     * binary files of users
     *
     * @param list, receives the list to write in the file
     */
    public void saveList(SaleList list) {
        try {
            fileWriter.clear(); // first clear the file
            fileWriter.open();

            fileWriter.write((SaleList) list);

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("No se puede guardar la lista\n" + e.getMessage());
        }
    }
}
