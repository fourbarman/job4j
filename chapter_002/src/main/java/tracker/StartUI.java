package tracker;

/**
 * StartUI.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 12.08.2019
 */
public class StartUI {
    private static final String EXIT = "0";
    private static final String ADD = "1";
    private static final String FINDALL = "2";
    private static final String REPLACE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String DELETE = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FINDALL.equals(answer)) {
                this.getAll();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (FINDBYID.equals(answer)) {
                this.findWithId();
            } else if (FINDBYNAME.equals(answer)) {
                this.findWithName();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавления новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки ------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId: " + item.getId() + "------------");
    }
    /**
     * Выводит все заявки из хранилища
     */
    public void getAll(){
        System.out.println("------------ Все заявки ------------");
        for(Item items: tracker.findAll()){
            System.out.println("ID заявки: " + items.getId() +
                            "Имя зявки: " + items.getName() +
                            "Комментарий: "+ items.getDesc() +
                            "Время создания: " + items.getTime());
        }
    }
    /**
     * Замена заявки.
     */
    public void replaceItem(){
        System.out.println("------------ Замена заявки ------------");
        String id = this.input.ask("Введите id заявки: ");
        if (this.tracker.findById(id) != null) {
            System.out.println("ID заявки: " + this.tracker.findById(id) + " " +
                    "Имя зявки: " + this.tracker.findById(id).getName() + " " +
                    "Комментарий: " + this.tracker.findById(id) + " " +
                    "Время создания: " + this.tracker.findById(id).getTime());
            String name = this.input.ask("Введите имя новой заявки: ");
            String desc = this.input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("ID заявки: " + this.tracker.findById(id) + " " +
                    "Имя зявки: " + this.tracker.findById(id).getName() + " " +
                    "Комментарий: " + this.tracker.findById(id) + " " +
                    "Время создания: " + this.tracker.findById(id).getTime());
        } else {
            System.out.println("Не существует таким c ID " + id);
        }
    }
    /**
     * Поиск заявок по ID.
     */
    public void findWithId() {
        String id = this.input.ask("Введите id заявки: ");
        if (this.tracker.findById(id) != null) {
            System.out.println("ID заявки: " + this.tracker.findById(id) + " " +
                    "Имя зявки: " + this.tracker.findById(id).getName() + " " +
                    "Комментарий: " + this.tracker.findById(id) + " " +
                    "Время создания: " + this.tracker.findById(id).getTime());
        } else {
            System.out.println("Не существует таким c ID " + id);
        }
    }
    /**
     * Поиск заявок по имени.
     */
    public void findWithName(){
        String name = this.input.ask("Введите имя заявки: ");
        if (this.tracker.findById(name) != null) {
            System.out.println("Результат поиска: ");
            for (Item items : tracker.findByName(name)) {
                System.out.println("ID заявки: " + items.getId() + " " +
                        "Имя зявки: " + items.getName() + " " +
                        "Комментарий: " + items.getDesc() + " " +
                        "Время создания: " + items.getTime());
            }
        } else {
            System.out.println("Не найдено заявок с именем: " + name);
        }
    }
    /**
     * Удаление заявки.
     */
    public void deleteItem(){
        String id = this.input.ask("Введите id заявки: ");
        if (this.tracker.findById(id) != null) {
            tracker.delete(id);
            System.out.println("Заявка удалена!");
        } else {
            System.out.println("Не существует таким c ID " + id);
        }
    }
    /**
     * Показывает меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("1. Добавление новой заявки");
        System.out.println("2. Показать все заявки");
        System.out.println("3. Редактирование заявки");
        System.out.println("4. Поиск заявки по ID");
        System.out.println("5. Поиск заявки по имени");
        System.out.println("6. Удалить заявку");
        System.out.println("0. Выход");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
