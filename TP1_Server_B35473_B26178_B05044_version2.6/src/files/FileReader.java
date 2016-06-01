package files;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import objectLists.SaleList;

/**
 * Class is responsible for write in the file. receives in the constructor the
 * name of the file to write in it
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 * @param <T>
 */
public class FileReader<T> {

    private ObjectInputStream reader;
    private final FileLoader loader;

    public FileReader(String fileName) {
        loader = new FileLoader(fileName);
    }

    /**
     * Open to read the file
     *
     * @throws java.io.IOException if it does not open properly
     */
    public void open() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(loader.getFile());
            reader = new ObjectInputStream(fileInputStream);

        } catch (EOFException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method is responsible for reading the file
     *
     * @return a read user
     * @throws java.io.IOException file error
     * @throws java.lang.ClassNotFoundException if the class is not looking
     * @throws java.io.EOFException if it is the end of file
     */
    public SaleList read() throws IOException, EOFException, ClassNotFoundException {
        return (SaleList) reader.readObject();
    }

    /**
     * Close the file after reading
     *
     * @throws java.io.IOException if there are problems when close the file
     */
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

}
