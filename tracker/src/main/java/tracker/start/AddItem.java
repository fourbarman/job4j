package tracker.start;
import tracker.models.*;
    /**
    * AddItem.
    * Adds items.
    *
    * @author fourbarman (maks.java@yandex.ru).
    * @version $Id$.
    * @since 21.02.2019.
    */
public class AddItem implements UserAction {

    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param key  Action key.
     * @param info Action info.
     */
    public AddItem(int key, String info) {
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
        return 0;
    }

    /**
     * Adds new Item in storage.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        if (tracker.findAll().length >= 99) {
            System.out.println("----------Хранилище заявок переполнено!----------");
        } else {
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Task task = new Task(name, desc);
            tracker.add(task);
            System.out.println("------------ Создана новая заявка с Id : " + task.getId() + "-----------");
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
        return "0. Add new Item";
    }
}
