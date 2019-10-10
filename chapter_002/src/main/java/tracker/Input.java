package tracker;

public interface Input {
    /*
    returns String value
     */
    String ask(String question);
    /*
    returns int value
     */
    int askInt(String question);
}
