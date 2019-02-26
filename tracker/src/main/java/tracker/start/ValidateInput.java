package tracker.start;

import java.util.List;

/**
 * ValidateInput.
 * Checks if user inputs correct data.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version $Id$.
 * @since 26.02.2019.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Overriden method for validating user input. If data incorrect,
     * throws exceptions and asks to enter correct data.
     *
     * @param question Ask user to do action.
     * @param range List of user actions.
     * @return Read user console input.
     */
    @Override
    public int ask(String question, List<UserAction> range) {
        boolean invalid = true;
        int value = -1;
        do {

            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select operation key from Menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter correct data");
            }
        }
            while (invalid);
                return value;

    }
}
