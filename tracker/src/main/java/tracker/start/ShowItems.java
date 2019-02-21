package tracker.start;
import tracker.models.*;

    /**
     * ShowItems.
     * Shows all items.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class ShowItems implements UserAction {

    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param key  Action key.
     * @param info Action info.
     */
    public ShowItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * Returns action key value.
     *
     * @return value.
     */
    @Override
    public int key() {
        return 1;
    }

    /**
     * Shows all Items in storage.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Все хранимые заявки --------------");
        if (tracker.findAll().length == 0) {
            System.out.println("На данный момент в системе не содержится ни одной заявки!");
        } else {
            tracker.findAll();
            for (Item items: tracker.findAll()) {
                System.out.println("ID " + items.getId()
                        + " Имя: " + items.getName()
                        + " Описание: " + items.getDescription());
            }
        }
        System.out.println("-----------------------------------------------");
    }

    /**
     * Returns action info.
     *
     * @return value.
     */
    @Override
    public String info() {
        return "1. Show all Items";
    }
}
