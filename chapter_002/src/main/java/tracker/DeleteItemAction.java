package tracker;

public class DeleteItemAction implements UserAction {

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete Item ------------");
        String id = input.ask("Enter item's ID: ");
        if (tracker.findById(id) != null) {
            tracker.delete(id);
            System.out.println("Item with " + id + " deleted!");
        }
        return true;
    }
}
