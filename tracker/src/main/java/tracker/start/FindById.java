package tracker.start;

public class FindById implements UserAction {

    private int key;
    private String info;

    public FindById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 4;
    }

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

    @Override
    public String info() {
        return "4. Find item by Id";
    }
}
