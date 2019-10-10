package tracker;

public class FindWithIdAction implements UserAction {

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("------------ Find Item By ID ------------");
        String id = input.ask("Enter item's ID: ");
        if (tracker.findById(id) != null) {
            System.out.println("------------ Found item ------------");
            System.out.println("Item's ID: " + tracker.findById(id).getId()
                    + " Item's name: " + tracker.findById(id).getName()
                    + " Description: " + tracker.findById(id).getDesc()
                    + " Birth time: " + tracker.findById(id).getTime());
        }
        return true;
    }
}
