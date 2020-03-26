package tracker.start;

import java.util.List;

/**
 * ValidateInput.
 * Checks if user inputs correct data.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version $Id$.
 * @since 27.08.2019.
 */
public class ValidateInput implements Input {

    /**
     * Overriden method for validating user input. If data incorrect,
     * throws exceptions and asks to enter correct data.
     */
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<UserAction> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return  value;
    }
}
