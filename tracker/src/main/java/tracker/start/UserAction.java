package tracker.start;

public interface UserAction {
    /**
     * Returns option key.
     * @return ключ
     */
    int key();
    /**
     * Main method.
     * @param input Input type object
     * @param tracker Tracker type object
     */
    void execute(Input input, Tracker tracker);
    /**
     * Returns option key information.
     * @return menu option
     */
    String info();
}
