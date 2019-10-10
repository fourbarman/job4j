package tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ Add new Item ------------");
        String name = input.ask("Item's name: ");
        String desc = input.ask("Item's description: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New item added with Id: " + item.getId() + "------------");
        return true;
    }
}
