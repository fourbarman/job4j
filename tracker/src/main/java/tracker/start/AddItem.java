package tracker.start;
import tracker.models.*;

public class AddItem implements UserAction {

    private int key;
    private String info;

    public AddItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 0;
    }

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

    @Override
    public String info() {
        return "0. Add new Item";
    }
}
