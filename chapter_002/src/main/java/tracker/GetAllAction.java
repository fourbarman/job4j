package tracker;

/**
 * GetAllAction.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.10.2019.
 */
public class GetAllAction extends BaseAction implements UserAction {

    /**
     * Constructor
     *
     * @param name Action name.
     */
    public GetAllAction(String name) {
        super(name);
    }

    /**
     * Shows all Items.
     *
     * @param input   Input.
     * @param tracker Item's storage.
     * @return True.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ All items ------------");
        for (Item items : tracker.findAll()) {
            System.out.println(String.format(
                    "Item's ID: %s Item's name: %s Description: %s Birth time: %d",
                    items.getId(),
                    items.getName(),
                    items.getDesc(),
                    items.getTime())
            );
        }
        return true;
    }
}
