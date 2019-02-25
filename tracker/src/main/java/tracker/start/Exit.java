package tracker.start;

    /**
     * Exit.
     * Exit program.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class Exit implements UserAction {

    private StartUI ui;
    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param ui   Current StartUI object.
     * @param key  Action key.
     * @param info Action info.
     */
    public Exit(StartUI ui, int key, String info) {
        this.key = key;
        this.info = info;
        this.ui = ui;
    }

    /**
     * Returns action key value.
     *
     * @return value.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Exit program.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.stop();
    }

    /**
     * Returns action info.
     *
     * @return value.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}
