package tracker.start;

public class Exit implements UserAction {

    private int key;
    private String info;
    private StartUI ui;

    public Exit(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.stop();
    }

    @Override
    public String info() {
        return "6. Exit program";
    }
}
