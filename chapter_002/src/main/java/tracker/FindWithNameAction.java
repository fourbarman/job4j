package tracker;

public class FindWithNameAction implements UserAction {

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ Find Item By Name ------------");
        String name = input.ask("Enter item's name: ");
        if (tracker.findByName(name) != null) {
            System.out.println("Found items: ");
            for (Item items : tracker.findByName(name)) {
                System.out.println(String.format(
                        "Item's ID: %s Item's name: %s Description: %s Birth time: %d",
                        items.getId(),
                        items.getName(),
                        items.getDesc(),
                        items.getTime())
                );
            }
        }
        return true;
    }
}
