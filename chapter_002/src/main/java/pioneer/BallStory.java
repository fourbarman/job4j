package pioneer;
/**
 * BallStory.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 05.08.2019.
 */

public class BallStory {
    /**
     * Main.
     *
     * @param args String arguments.
     */
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
    }
}
