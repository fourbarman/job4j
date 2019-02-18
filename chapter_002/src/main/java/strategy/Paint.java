package strategy;

/**
 * Paint.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 15.02.2019.
 */
public class Paint {
    /**
     * Adds new Item to storage.
     *
     * @param shape Shape to draw.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    /**
     * Main.
     *
     * @param args String arguments.
     */
    public static void main(String[] args) {
        Paint p = new Paint();
        p.draw(new Square());
        System.out.println(System.lineSeparator());
        p.draw(new Triangle());
    }
}
