package managerList;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import models.SaleModel;
import models.UserModel;
import objectLists.UsersList;
import usersBuilder.ConcreteBuilderCreateUser;
import usersBuilder.CustomException;
import usersBuilder.Director;

/**
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class Main {

    public static void main(String[] args) throws CustomException {

        ListLoader listLoader = new ListLoader(enums.EnumFiles.SALE_FILE_NAME.getValue());
        ListSaver listSaver = new ListSaver(enums.EnumFiles.SALE_FILE_NAME.getValue());
        
        List<List<SaleModel>> listaDeListas = new ArrayList<List<SaleModel>>();
        
        List<SaleModel> list = new ArrayList<SaleModel>();
        list.add(new SaleModel(new UserModel(), "toyota", "toyota", 2001, "iddelCarro", "Color del carro", "descripcion", 7, 130000));
        
        listaDeListas.add(list);
        
        listSaver.saveList(listaDeListas);
        
        List<List<SaleModel>> listaDeListas2 = ( List<List<SaleModel>> ) listLoader.loadList();
        
        SaleModel model = (SaleModel)listaDeListas2.get(0).get(0);
        
        System.out.println("" + model.getCarId());
        
    }

}
