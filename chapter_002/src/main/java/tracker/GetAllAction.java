package tracker;

public class GetAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ All items ------------");
        for (Item items: tracker.findAll()) {
            System.out.println("Item's ID: " + items.getId()
                    + " Item's name: " + items.getName()
                    + " Description: " + items.getDesc()
                    + " Birth time: " + items.getTime());
        }
        return true;
    }
}
