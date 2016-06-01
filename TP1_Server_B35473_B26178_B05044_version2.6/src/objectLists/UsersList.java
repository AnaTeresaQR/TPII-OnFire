package objectLists;

import enums.EnumFiles;
import java.util.ArrayList;
import java.util.List;
import managerList.ListLoader;
import managerList.ListSaver;
import usersBuilder.CustomException;
import models.UserModel;

/**
 * Class that is responsible for handling the user list, is responsible for
 * registering a user or logging a user in the system. Only this class can
 * create an instance of itself. Singleton pattern
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class UsersList {

    private List<UserModel> userslist;

    public UsersList() {
        userslist = new ArrayList<>();
    }

    /**
     * registers a user, adds a user into the list, returns true if can
     * register, or false if failing to register
     *
     * @param user, receives the user to register
     * @return true, if a user could register, false if a user failed to
     * register
     */
    public boolean register(UserModel user) {
        if (!exist(user)) {
            return userslist.add(user);
        }
        return false;
    }

    /**
     * Login a user, search in the user list
     *
     * @param email receives the email to search in the list, if the user exist
     * @param password receives the password to search in the list, if the user
     * exist with the email and the password is correct too
     * @return the user found
     */
    public UserModel login(String email, String password) {
        for (UserModel temp : userslist) {
            // ask if the email is correct
            if (temp.getEmail().equals(email)) {
                // ask if the password is correct
                if (temp.getPassword().equals(password)) {
                    // return the user found
                    return temp;
                } else {
                    // the user is not found 
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Returns a user in the list with the index in this list
     *
     * @param index ,the index for search in the list
     * @return the user that matches the list
     */
    public UserModel getUser(int index) {
        if (index >= 0 && index < userslist.size()) {
            return userslist.get(index);
        }
        throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    /**
     * Check if a user already exist in the list with te same email or with the
     * same id
     *
     * @param user, receives the user to compare with the elements of the list
     * @return, true if have the same attributes with another object in the
     * list, false if does not existe the local object
     */
    public boolean exist(UserModel user) {
        for (int i = 0; i < userslist.size(); i++) {
            if (userslist.get(i).getEmail().equals(user.getEmail())
                    || userslist.get(i).getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Contains the size of the list
     *
     * @return the size of the list
     */
    public int size() {
        return userslist.size();
    }

    /**
     * Refreshes the list if new users are added
     */
    public void refresh() {
        userslist.clear();
        listLoader();
    }

    /**
     * Load the list with file elements
     */
    public void listLoader() {
        ListLoader<UserModel> loader = new ListLoader<>(EnumFiles.USER_FILE_NAME.getValue());
        this.userslist = (List<UserModel>) loader.loadList();
    }

    /**
     * Save the list in the binary file
     */
    public void save() {
        ListSaver<UserModel> save = new ListSaver<>(EnumFiles.USER_FILE_NAME.getValue());
        save.saveList(this.userslist);
    }

}
