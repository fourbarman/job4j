package tracker.start;
import tracker.models.*;

    /**
     * EditItem.
     * Edits items.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class EditItem implements UserAction {

    private int key;
    private String info;

    /**
     * Constructor.
     *
     * @param key  Action key.
     * @param info Action info.
     */
    public EditItem(int key, String info) {
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
        return 2;
    }

    /**
     * Deletes Item in storage.
     *
     * @param input User input.
     * @param tracker Item container.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите id заявки: ");
        if (tracker.findById(id) == null) {
            System.out.println("------------ Не найдено заявки по указанному ID --------------");
        } else {
            System.out.println("------------ Данные редактируемой заявки --------------");
            System.out.println("ID " + tracker.findById(id).getId()
                    + " Имя: " + tracker.findById(id).getName()
                    + " Описание: " + tracker.findById(id).getDescription());
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Task task = new Task(name, desc);
            tracker.replace(id, task);
            System.out.println("------------ Заявка с новыми данными --------------");
            System.out.println("ID: " + tracker.findById(id).getId()
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
        return "2. Edit item";
    }
}
