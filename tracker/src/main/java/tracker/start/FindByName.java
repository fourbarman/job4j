package tracker.start;
import tracker.models.*;

    /**
     * FindByName.
     * Finds items by name.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class FindByName implements UserAction {

    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param key  Action key.
     * @param info Action info.
     */
    public FindByName(int key, String info) {
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
        return 5;
    }

    /**
     * Finds items by name.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = input.ask("Введите имя заявки :");
        if (tracker.findByName(name).length == 0) {
            System.out.println("------------ Не найдено ни одной заявки по указанному имени --------------");
        } else {
            System.out.println("------------ Найденные заявки --------------");
            for (Item items : tracker.findByName(name)
            ) {
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
        return String.format("%s. %s", this.key(), this.info);
    }
}
