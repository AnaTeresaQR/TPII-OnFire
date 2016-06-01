package managerList;

import files.FileReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import objectLists.SaleList;

/**
 * Class is responsible for loading a list of objects stored in a binary file
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 * @param <T> the object that will be load in the list
 */
public class ListLoader<T> {

    private FileReader<T> reader;

    public ListLoader(String fileName) {
        reader = new FileReader<>(fileName);
    }

    /**
     * Add users in the list, that are in the file
     *
     * @return the list of loaded elements
     */
    public List<T> loadList() {
        List<T> list = new ArrayList<>();
        try {
            reader.open(); // open it
            list = reader.read(); // add the object in the list, that is in the file
            return list;
            // If we read to the end of file
        } catch (EOFException e) {
            System.out.println("Error al terminar de leer el archivo");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Hubo un error en el archivo o no se encontrò la clase que se buscaba\n" + ex.getMessage());
        } catch (NullPointerException e) {
            // when clear the file the list is empty, and need to load elements in the list, we need to create a new List
            return list;
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                reader = null;
            }
        }
        return list;
    }
}
