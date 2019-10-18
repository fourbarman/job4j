package tracker;

/**
 * Input.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.10.2019.
 */
public interface Input {
    /*
    returns String value
     */
    String ask(String question);

    /*
    returns int value
     */
    int askInt(String question);

    /*
    checks menu value
     */
    int askInt(String question, int max);
}
