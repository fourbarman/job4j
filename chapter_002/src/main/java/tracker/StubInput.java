package tracker;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(ask(question));
}

    @Override
    public int askInt(String question, int max) {
        return askInt(question);
    }
}


