package tracker;

/**
 * UserAction.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.10.2019.
 */
public interface UserAction {
    /**
     * User action name.
     *
     * @return Name.
     */
    String name();

    /**
     * Executes user actions.
     *
     * @param input   Input.
     * @param tracker Item's storage.
     */
    boolean execute(Input input, Tracker tracker);
}
