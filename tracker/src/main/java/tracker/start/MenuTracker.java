package tracker.start;

import java.util.ArrayList;
import java.util.List;
    /**
     * MenuTracker.
     * Shows program menu options and interacts with user input.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version $Id$.
     * @since 21.02.2019.
     */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public List<UserAction> getActions() {
        return actions;
    }

    /**
     * Constructor.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Fills array.
     *
     * @param ui StartUI.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all Items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete Item"));
        this.actions.add(new FindById(4, "Find item by Id"));
        this.actions.add(new FindByName(5, "Find items by name"));
        this.actions.add(new Exit(ui, 6, "Exit program"));
    }

    /**
     * Does actions depending on key.
     *
     * @param key action key.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Shows Menu.
     */
    public void show() {
        System.out.println("MENU");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
