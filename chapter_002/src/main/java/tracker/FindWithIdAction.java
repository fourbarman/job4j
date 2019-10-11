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
            System.out.println(String.format(
                    "Item's ID: %s Item's name: %s Description: %s Birth time: %d",
                    tracker.findById(id).getId(),
                    tracker.findById(id).getName(),
                    tracker.findById(id).getDesc(),
                    tracker.findById(id).getTime())
            );
        }
        return true;
    }
}
