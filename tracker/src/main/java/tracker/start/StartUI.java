package tracker.start;
import tracker.models.*;

public class StartUI {
    private Input input;
    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        String name = input.ask("Enter task name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Task(name, "desc"));
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
    }
	public static void main(String[] args) {
        Input input = new ConsoleInput();
		new StartUI(input).init();
	}
}