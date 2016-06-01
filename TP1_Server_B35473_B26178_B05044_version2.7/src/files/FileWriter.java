package files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.util.Collections.list;
import java.util.List;
import models.SaleModel;
import objectLists.SaleList;

/**
 * To open an object file that can be generic
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 * @param <T> object .can be users or auctions (subastas)
 */
public class FileWriter<T> {

    private ObjectOutputStream writer;
    private final FileLoader loader; // class that load the file

    public FileWriter(String fileName) {
        loader = new FileLoader(fileName);
    }

    /**
     * Open the log file
     *
     * @throws java.io.IOException exception if there was error opening the file
     */
    public void open() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(loader.getFile());
        writer = new ObjectOutputStream(fileOutputStream);
    }

    /**
     * It is responsible for writing to the file
     *
     * @param <error>
     * @param list, receives the list that is to be written, can be a user or
     * sales
     * @throws java.io.IOException if an error occurs when writing
     */
    public void write(List<T> list) throws IOException {
        writer.writeObject(list); // write in the file
    }

    /**
     * Clear the file
     *
     * @throws IOException, Invalid file path
     */
    public void clear() throws IOException {
        loader.clear();
    }

    /**
     * Close the file
     *
     * @throws java.io.IOException if there was error closing file
     */
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}
