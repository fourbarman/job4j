package tracker.start;

    /**
    * MenuOutException.
    * Sends Exceptions to RuntimeException.
    *
    * @author fourbarman (maks.java@yandex.ru).
    * @version $Id$.
    * @since 26.02.2019.
    */
public class MenuOutException extends RuntimeException {
    /**
     * Constructs a new exception and sends to RuntimeException.
     *
     * @param msg   the detail massage.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
