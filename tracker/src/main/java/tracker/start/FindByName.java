package tracker.start;
import tracker.models.*;

public class FindByName implements UserAction {

    private int key;
    private String info;

    public FindByName(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 0;
    }

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

    @Override
    public String info() {
        return "5. Find items by name";
    }
}
