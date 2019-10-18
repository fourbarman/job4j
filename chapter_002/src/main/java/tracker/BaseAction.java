package tracker;

/**
 * BaseAction.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.10.2019.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Action name field.
     */
    private final String name;

    /**
     * Constructor
     *
     * @param name action name.
     */
    protected BaseAction(String name) {
        this.name = name;
    }

    /**
     * Returns action name.
     *
     * @return
     */
    @Override
    public String name() {
        return this.name;
    }
}
