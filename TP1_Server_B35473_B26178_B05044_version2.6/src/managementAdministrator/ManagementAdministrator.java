package managementAdministrator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Edgardo Quirós
 */
public class ManagementAdministrator {

    private String administrator;
    private String password;

    public ManagementAdministrator() {
        chargeInfo();
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void chargeInfo() {
        Properties propiedades = new Properties();
        InputStream entrada = null;

        try {

            entrada = new FileInputStream("ManagementAdministrator.properties");

            // cargamos el archivo de propiedades
            propiedades.load(entrada);

            // obtenemos las propiedades y las guardamos
            setAdministrator(propiedades.getProperty("administrador"));

            setPassword(propiedades.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean login(String ad, String pass) {
        return ad.equals(getAdministrator()) && pass.equals(getPassword());
    }

}
