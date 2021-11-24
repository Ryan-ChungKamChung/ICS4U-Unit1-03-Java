/*
 * This class is a custom exception that is thrown if the user inputs a number
 * under 1 or over 3.
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2021-11-19
 */

/**
* This class contains the error thrown if the user inputs something that isn't
* between 1-3.
*/
public class IncorrectQuantityException extends Exception {

    /**
     * This function is an Exception, with an overridden error message.
     * */
    public IncorrectQuantityException() {
        super("The quantity you inputted was not between 1-3.");
    }
}

