package managementAdministrator;

import salesBuilder.ConcreteBuilderCreateSale;
import usersBuilder.CustomException;

/**
 *
 * @author Edgardo Quirós
 */
public class MainAdministrator {

    /**
     * @param args the command line arguments
     * @throws usersBuilder.CustomException
     */
    public static void main(String[] args) throws CustomException {
//       Properties propiedades = new Properties();
//    InputStream entrada = null;
//
//    try {
//
//        entrada = new FileInputStream("prueba.properties");
//
//        // cargamos el archivo de propiedades
//        propiedades.load(entrada);
//
//        // obtenemos las propiedades y las imprimimos
//        System.out.println(propiedades.getProperty("usuario"));
//        System.out.println(propiedades.getProperty("password"));
//
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    } finally {
//        if (entrada != null) {
//            try {
//                entrada.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        ConcreteBuilderCreateSale cu = null;
        String placa = "123ASC";
        cu.buildCarId(placa);
//        
//        boolean prueba=cu.checkCarId();
//        System.out.println(prueba);

    }
}
