/*
 * This class is a custom exception that is thrown if the user inputs anything
 * that isn't one of the listed options for food.
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2021-11-19
 */

/**
* This class contains the error thrown if the user inputs something that isn't
* "sub", "soup" or "pizza" and it is extended from the Exception class.
*/
public class FoodItemNotFoundException extends Exception {

    /**
     * This function is an Exception, with an overridden error message.
     * */
    public FoodItemNotFoundException() {
        super("Not a valid food item from the list.");
    }
}

