package tracker.start;
import tracker.models.*;

public class StartUI {
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		tracker.add(new Task("task", "desc"));
		for (Item item : tracker.findAll()) {
			System.out.println(item.getName());
		}
	}
}