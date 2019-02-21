package tracker.start;
import tracker.models.*;

public class EditItem implements UserAction {

    private int key;
    private String info;

    public EditItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 2;
    }

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

    @Override
    public String info() {
        return "2. Edit item";
    }
}
