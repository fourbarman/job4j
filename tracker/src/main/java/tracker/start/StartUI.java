package tracker.start;

import tracker.models.*;

/**
 * StartUI.
 * Interacts with user console.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 15.11.2018.
 */
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

    /**
     * Constructor.
     *
     * @param input User console input.
     * @param tracker Task storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Initialises menu & interacts with user console.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.getAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDID.equals(answer)) {
                this.findWithId();
            } else if (FINDNAME.equals(answer)) {
                this.findWithName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Show menu.
     */
    public void showMenu() {
        System.out.print("MENU" + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all Items" + System.lineSeparator()
                + "2. Edit item" + System.lineSeparator()
                + "3. Delete Item" + System.lineSeparator()
                + "4. Find item by Id" + System.lineSeparator()
                + "5. Find items by name" + System.lineSeparator()
                + "6. Exit program" + System.lineSeparator()
                + "Select: ");
    }

    /**
     * Adds Task.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Task task = new Task(name, desc);
        this.tracker.add(task);
        System.out.println("------------ Новая заявка с Id : " + task.getId() + "-----------");
        System.out.println("-----------------------------------------------");
    }

    /**
     * Gets all stored Tasks.
     */
    public void getAll() {
        System.out.println("------------ Все хранимые заявки --------------");
        this.tracker.findAll();
        for (Item items: this.tracker.findAll()) {
            System.out.println("ID " + items.getId()
                    + "Имя: " + items.getName()
                    + "Описание: " + items.getDescription());
        }
        System.out.println("-----------------------------------------------");
    }

    /**
     * Edit Task founded by Id.
     */
    public void edit() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        System.out.println("------------ Данные редактируемой заявки --------------");
        System.out.println("ID " + this.tracker.findById(id).getId()
                        + "Имя: " + this.tracker.findById(id).getName()
                        + "Описание: " + this.tracker.findById(id).getDescription());
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Task task = new Task(name, desc);
        this.tracker.replace(id, task);
        System.out.println("------------ Заявка с новыми данными --------------");
        System.out.println("ID " + this.tracker.findById(id).getId()
                        + "Имя: " + this.tracker.findById(id).getName()
                        + "Описание: " + this.tracker.findById(id).getDescription());
        System.out.println("-----------------------------------------------");
    }

    /**
     * Deletes Task founded by Id.
     */
    public void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Заявка с ID " + id + " удалена--------------");
        System.out.println("-----------------------------------------------");
    }

    /**
     * Finds Task by Id.
     */

    public void findWithId() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        System.out.println("------------ Найденная заявка --------------");
        System.out.println("ID " + this.tracker.findById(id).getId()
                        + "Имя: " + this.tracker.findById(id).getName()
                        + "Описание: " + this.tracker.findById(id).getDescription());
        System.out.println("-----------------------------------------------");
    }

    /**
     * Finds Task by name.
     */
    public void findWithName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        System.out.println("------------ Найденные заявки --------------");
        for (Item items : this.tracker.findByName(name)
        ) {
            System.out.println("ID " + items.getId()
                            + "Имя: " + items.getName()
                            + "Описание: " + items.getDescription());
        }
        System.out.println("-----------------------------------------------");
    }

    /**
     * Main method.
     *
     * @param args String array.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}