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
            System.out.println("Item's ID: " + tracker.findById(id).getId()
                    + " Item's name: " + tracker.findById(id).getName()
                    + " Description: " + tracker.findById(id).getDesc()
                    + " Birth time: " + tracker.findById(id).getTime());
            String name = input.ask("Enter new item's name: ");
            String desc = input.ask("Enter new item's description: ");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("Item's ID: " + tracker.findById(id).getId()
                    + " Item's name: " + tracker.findById(id).getName()
                    + " Description: " + tracker.findById(id).getDesc()
                    + " Birth time: " + tracker.findById(id).getTime());
        }
        return true;
    }
}
