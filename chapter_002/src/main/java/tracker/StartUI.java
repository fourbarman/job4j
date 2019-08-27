package tracker;

/**
 * StartUI.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 12.08.2019
 */
public class StartUI {
    /**
     * Get data from user.
     */
    private Input input;
    /**
     * items storage.
     */
    private Tracker tracker;

    /**
     * Constructor.
     * @param input data in.
     * @param tracker items storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public StartUI() {

    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("MENU");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    /**
     * Program start.
     * @param args Args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new GetAllAction(),
                new ReplaceItemAction(),
                new DeleteItemAction(),
                new FindWithIdAction(),
                new FindWithNameAction(),
                new ExitAction()
        };
        new StartUI().init(validate, tracker, actions);
    }
}
