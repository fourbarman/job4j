package tracker.start;

import java.util.List;

/**
     * Input.
     * Interface.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public interface Input {
    /**
     * Ask user to enter something.
     */
    String ask(String question);

    /**
     * Does actions depending on key.
     *
     * @param question ask user to do action.
     * @param range list of user actions.
     */
    int ask(String question, List<UserAction> range);
    //int ask(String question, int[] range);
}
