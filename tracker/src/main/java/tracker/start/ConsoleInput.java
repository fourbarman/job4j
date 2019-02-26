package tracker.start;

import java.util.*;
    /**
     * ConsoleInput.
     * Gets user console input.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Adds new Item in storage.
     *
     * @param question Ask user to do action.
     * @return Read user console input.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
    * Overriden method for validating user input.
    *
    * @param question Ask user to do action.
    * @param range List of user actions.
    * @return Read user console input.
    */
    @Override
    public int ask(String question, List<UserAction> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
            for (UserAction value: range) {
                if (value.key() == key) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                return key;
            } else {
                throw new MenuOutException("Out of menu range");
            }
        }
    }
