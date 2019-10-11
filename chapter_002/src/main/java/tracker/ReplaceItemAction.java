package tracker;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ Replace item ------------");
        String id = input.ask("Enter Item's ID: ");
        if (tracker.findById(id) != null) {
            System.out.println(String.format(
                    "Item's ID: %s Item's name: %s Description: %s Birth time: %d",
                    tracker.findById(id).getId(),
                    tracker.findById(id).getName(),
                    tracker.findById(id).getDesc(),
                    tracker.findById(id).getTime()));
            String name = input.ask("Enter new item's name: ");
            String desc = input.ask("Enter new item's description: ");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println(String.format(
                    "Item's ID: %s Item's name: %s Description: %s Birth time: %d",
                    tracker.findById(id).getId(),
                    tracker.findById(id).getName(),
                    tracker.findById(id).getDesc(),
                    tracker.findById(id).getTime()));
        }
        return true;
    }
}
