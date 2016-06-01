package files;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Class is responsible for loading the file. receives in the constructor the
 * name of the file to load
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class FileLoader {

    URL url = null; // Unified resource located
    File userFile;
    String fileName; // name of the file

    public FileLoader(String fileName) {
        this.fileName = fileName;
        load();
    }

    /**
     * First search the file path, and load the binary file to a File
     */
    private void load() {
        try {
            this.url = getClass().getResource(fileName);
            this.userFile = new File(url.toURI());

        } catch (URISyntaxException e) {
            System.err.println("Error en el URI");
        }
    }

    /**
     * Send a File to be loaded
     *
     * @return File containing information about the userfile
     */
    public File getFile() {
        return this.userFile;
    }

    /**
     * Deletes the file with information and creates an empty with the same path
     *
     * @throws IOException, Invalid file path
     */
    public void clear() throws IOException {
        userFile.delete();
        userFile.createNewFile();
    }
}
