/*
 * This program calculates how much time it would take to cook a sub, soup or
 * pizza in quantities of 1-3
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2021-11-23
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* This class calculates the cooking time of a subset of food items.
*/
final class Microwave {

    // Public Constant Declarations
    /**
     * This constant represents the time it would take to heat up a sub inside
     * of the microwave in seconds.
     */
    public static final int SUB_HEATING_TIME = 60;

    /**
     * This constant represents the time it would take to heat up a soup inside
     * of the microwave in seconds.
     */

    public static final int SOUP_HEATING_TIME = 105;

    /**
     * This constant represents the time it would take to heat up a pizza inside
     * of the microwave in seconds.
     */
    public static final int PIZZA_HEATING_TIME = 45;

    /**
     * This constant represents the time multiplier needed to heat up 2 items
     * (50% added time).
     */
    public static final double TWO_ITEM_MULTIPLIER = 1.5;

    /**
     * This constant represents the time multiplier needed to heat up 3 items
     * (100% added time).
     * */
    public static final int THREE_ITEM_MULTIPLIER = 2;

    /**
     * This constant represents the amount of seconds in a minute (60 seconds
     * in a minute).
     * */
    public static final int SECS_IN_MIN = 60;

    /**
     * This constant represents one item if the user inputs 1 in quantityInput.
     * */
    public static final int ONE_ITEM = 1;

    /**
     * This constant represents two items if the user inputs 2 in
     * quantityInput.
     * */
    public static final int TWO_ITEMS = 2;

    /**
     * This constant represents three items if the user inputs 3 in
     * quantityInput.
     * */
    public static final int THREE_ITEMS = 3;

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private Microwave() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Calculates and outputs the energy generated from a certain amount of
     * mass.
     *
     * @param args No args will be used.
     * @throws IOException if there is anything wrong with the input
     * @throws NumberFormatException if quantityInput isn't a number
     * @throws FoodItemNotFoundException if the foodItemInput isn't "sub",
     *     "soup" or "pizza"
     * @throws IncorrectQuantityException if the quantityInput isn't between
     *     1-3
     * */
    public static void main(final String[] args)
            throws NumberFormatException, IOException {

        // Variable Declarations
        final String foodItemInput;
        final String foodItemInputLowercase;
        final String quantityInputString;
        final int quantityInput;

        double totalSecondsToCook = 0;
        final double minutesToCook;
        final double secondsToCook;

        try {
            // User prompt
            System.out.print("What food item would you like to heat up?"
                    + "(soup, sub or pizza): ");

            // Gathers and parses input to a String
            foodItemInput = new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();

            // Lowercase version of foodItemInput in case of typos
            foodItemInputLowercase = foodItemInput.toLowerCase();

            // Checks what the user inputted and decides the amount of time
            // that will be needed for one item
            switch (foodItemInputLowercase) {
                case "soup":
                    totalSecondsToCook = SOUP_HEATING_TIME;
                    break;
                case "sub":
                    totalSecondsToCook = SUB_HEATING_TIME;
                    break;
                case "pizza":
                    totalSecondsToCook = PIZZA_HEATING_TIME;
                    break;
                default:
                    throw new FoodItemNotFoundException();
            }

            // User prompt
            System.out.print("How many items would you like to heat up? ");

            // Gathers and parses input to a String
            quantityInputString = new BufferedReader(
                new InputStreamReader(System.in)
            ).readLine();

            // Parses String version of the input as an Int
            quantityInput = Integer.parseInt(quantityInputString);

            // Checks what the user inputted and decided the time multiplier
            // for the cooking time based on their input (1-3)
            switch (quantityInput) {
                case ONE_ITEM:
                    break;
                case TWO_ITEMS:
                    totalSecondsToCook =
                        totalSecondsToCook * TWO_ITEM_MULTIPLIER;
                    break;
                case THREE_ITEMS:
                    totalSecondsToCook =
                        totalSecondsToCook * THREE_ITEM_MULTIPLIER;
                    break;
                default:
                    throw new IncorrectQuantityException();
            }

            // Calculates the amount of time in minutes and seconds needed to
            // cook the food items
            minutesToCook = Math.floor(totalSecondsToCook / SECS_IN_MIN);
            secondsToCook = totalSecondsToCook % SECS_IN_MIN;

            // Outputs the calculations in a human-readable form
            System.out.println("It would take "
                    + String.format("%.0f", minutesToCook) + " minutes and "
                    + String.format("%.01f", secondsToCook)
                    + " seconds to cook.");
        } catch (FoodItemNotFoundException
                | IncorrectQuantityException exception) {
            // Prints the exception messages
            System.err.print(exception);
        } catch (IOException | NumberFormatException exception) {
            // Outputs error message
            System.out.println("Please enter a correct input.");
        }

        System.out.println("\nDone.");

    }

}

