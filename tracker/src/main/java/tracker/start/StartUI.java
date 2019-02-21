package tracker.start;

/**
 * StartUI.
 * Interacts with user console.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 15.11.2018.
 */
public class StartUI {

    private final Input input;

    private final Tracker tracker;

    private boolean stop = false;

    public void stop() {
        this.stop = true;
    }

    /**
     * Constructor.
     *
     * @param input   User console input.
     * @param tracker Task storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Initialises menu & interacts with user console.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while (!this.stop) {
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("select:")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));

        }

        /**
         * Main method.
         *
         * @param args String array.
         */
    }

    public static void main (String[]args){
        new StartUI(new ConsoleInput(), new Tracker()).init();
        }
    }
