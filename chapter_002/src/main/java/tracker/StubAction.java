package tracker;

/**
 * StubAction.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 18.10.2019
 */
public class StubAction implements UserAction {
    /**
     * Check if menu option is chosen.
     */
    private boolean call = false;

    /**
     * Returns menu option.
     *
     * @return String.
     */
    @Override
    public String name() {
        return "Stub action";
    }

    /**
     * Uses user action.
     *
     * @param input   Input.
     * @param tracker Item's storage.
     * @return False.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    /**
     * Stops program run.
     *
     * @return call.
     */
    public boolean isCall() {
        return call;
    }
}
