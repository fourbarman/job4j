package strategy;

/**
 * Triangle.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 15.02.2019.
 */
public class Triangle implements Shape{
    /**
     * Draws triangle.
     */
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("  *  "); sb.append(System.lineSeparator());
        sb.append(" * * "); sb.append(System.lineSeparator());
        sb.append("*   *"); sb.append(System.lineSeparator());
        sb.append("*****");
        return sb.toString();
    }
}
