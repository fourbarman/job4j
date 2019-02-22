package tracker.start;

    /**
     * DeleteItem.
     * Delete items.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class DeleteItem implements UserAction {

    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param key  Action key.
     * @param info Action info.
     */
    public DeleteItem(int key, String info) {
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
        return 3;
    }

    /**
     * Deletes Item from storage.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите id заявки :");
        if (tracker.findById(id) == null) {
            System.out.println("------------ Не найдено заявки по указанному ID --------------");
        } else {
            tracker.delete(id);
            System.out.println("------------ Заявка с ID " + id + " удалена--------------");
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
