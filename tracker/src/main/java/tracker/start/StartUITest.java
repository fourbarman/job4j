package tracker.start;

public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[]{"create stub task"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}