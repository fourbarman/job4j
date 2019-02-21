package tracker.start;
import tracker.models.*;

public class ShowItems implements UserAction {

    private int key;
    private String info;

    public ShowItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 1;
    }

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

    @Override
    public String info() {
        return "1. Show all Items";
    }
}
