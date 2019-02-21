package tracker.start;
import tracker.models.*;

public class DeleteItem implements UserAction {

    private int key;
    private String info;

    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 3;
    }

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

    @Override
    public String info() {
        return "3. Delete Item";
    }
}
