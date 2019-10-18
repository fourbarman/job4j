package tracker;

public abstract class BaseAction implements UserAction {
    private final String name;

    protected BaseAction(String name) {
        this.name = name;
    }
    @Override
    public String name() {
        return this.name;
    }
}
