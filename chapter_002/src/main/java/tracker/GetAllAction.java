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
