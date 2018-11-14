package tracker.start;
import tracker.models.*;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            //} else if (SHOW.equals(answer)) {
             //Добавить остальные действия системы по меню.
                //this.getAll();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Show menu.
     */
    public void showMenu() {
        System.out.print("MENU" + System.lineSeparator() +
                "0. Add new Item" + System.lineSeparator() +
                "1. Show all Items" + System.lineSeparator() +
                "2. Edit item" + System.lineSeparator() +
                "3. Delete Item" + System.lineSeparator() +
                "4. Find item by Id" + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit program" + System.lineSeparator() +
                "Select: ");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Task task = new Task(name, desc);
        this.tracker.add(task);
        System.out.println("------------ Новая заявка с getId : " + task.getId() + "-----------");
    }

    //public void String[] getAll() {
        //return
    //}

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}