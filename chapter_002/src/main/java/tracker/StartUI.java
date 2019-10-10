package tracker;

/**
 * StartUI.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 12.08.2019
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String FINDALL = "1";
    private static final String REPLACE = "2";
    private static final String FINDBYID = "3";
    private static final String FINDBYNAME = "4";
    private static final String DELETE = "5";
    private static final String EXIT = "6";
    /**
     * Get data from user.
     */
    private final Input input;
    /**
     * items storage.
     */
    private final Tracker tracker;

    /**
     * Constructor.
     * @param input data in.
     * @param tracker items storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Main cycle.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select : ");
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
     * Add new Item.
     */
    private void createItem() {
        System.out.println("------------ Add new Item ------------");
        String name = this.input.ask("Item's name: ");
        String desc = this.input.ask("Item's description: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New item added with Id: " + item.getId() + "------------");
    }
    /**
     * Show all items.
     */
    public void getAll() {
        System.out.println("------------ All items ------------");
        for (Item items: tracker.findAll()) {
            System.out.println("Item's ID: " + items.getId()
                            + " Item's name: " + items.getName()
                            + " Description: " + items.getDesc()
                            + " Birth time: " + items.getTime());
        }
    }
    /**
     * Replace item.
     */
    public void replaceItem() {
        System.out.println("------------ Replace item ------------");
        String id = this.input.ask("Enter Item's ID: ");
        if (this.tracker.findById(id) != null) {
            System.out.println("Item's ID: " + this.tracker.findById(id).getId()
                            + " Item's name: " + this.tracker.findById(id).getName()
                            + " Description: " + this.tracker.findById(id).getDesc()
                            + " Birth time: " + this.tracker.findById(id).getTime());
            String name = this.input.ask("Enter new item's name: ");
            String desc = this.input.ask("Enter new item's description: ");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("Item's ID: " + this.tracker.findById(id).getId()
                            + " Item's name: " + this.tracker.findById(id).getName()
                            + " Description: " + this.tracker.findById(id).getDesc()
                            + " Birth time: " + this.tracker.findById(id).getTime());
        }
    }
    /**
     * Find item by ID.
     */
    public void findWithId() {
        String id = this.input.ask("Enter item's ID: ");
        if (this.tracker.findById(id) != null) {
            System.out.println("------------ Found item ------------");
            System.out.println("Item's ID: " + this.tracker.findById(id).getId()
                            + " Item's name: " + this.tracker.findById(id).getName()
                            + " Description: " + this.tracker.findById(id).getDesc()
                            + " Birth time: " + this.tracker.findById(id).getTime());
        }
    }
    /**
     * Finds items by name.
     */
    public void findWithName() {
        String name = this.input.ask("Enter item's name: ");
        if (this.tracker.findByName(name) != null) {
            System.out.println("Found items: ");
            for (Item items : tracker.findByName(name)) {
                System.out.println("Item's ID: " + items.getId()
                                + " Item's name: " + items.getName()
                                + " Description: " + items.getDesc()
                                + " Birth time: " + items.getTime());
            }
        }
    }
    /**
     * Delete item.
     */
    public void deleteItem() {
        String id = this.input.ask("Enter item's ID: ");
        if (this.tracker.findById(id) != null) {
            tracker.delete(id);
            System.out.println("Item with " + id + " deleted!");
        }
    }
    /**
     * Show menu.
     */
    private void showMenu() {
        System.out.println("MENU");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Find items by Id");
        System.out.println("4. Find item by name");
        System.out.println("5. Delete item");
        System.out.println("6. Exit");
    }

    /**
     * Program start.
     * @param args Args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
