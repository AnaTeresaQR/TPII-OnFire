package usersBuilder;

/**
 * Class interface that extends of Java Exception to cover exceptions in the
 * system.
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class CustomException extends Exception {

    /**
     * Class constructor
     *
     * @param message displayed when an exception occurs
     */
    public CustomException(String message) {
        super(message);
    }
}
