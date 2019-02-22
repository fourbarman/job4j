package tracker.start;

    /**
     * FindByID.
     * Finds items by ID.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class FindById implements UserAction {

    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param key  Action key.
     * @param info Action info.
     */
    public FindById(int key, String info) {
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
        return 4;
    }

    /**
     * Finds Items in storage.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявок по ID --------------");
        String id = input.ask("Введите id заявки :");
        if (tracker.findById(id) == null) {
            System.out.println("------------ Не найдено заявки по указанному ID --------------");
        } else {
            System.out.println("------------ Найденная заявка --------------");
            System.out.println("ID " + tracker.findById(id).getId()
                    + " Имя: " + tracker.findById(id).getName()
                    + " Описание: " + tracker.findById(id).getDescription());
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
