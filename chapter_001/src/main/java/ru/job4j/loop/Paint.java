package ru.job4j.loop;
import java.util.function.BiPredicate;
/**
 * Paint.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 29.08.2018.
 */
public class Paint {
    /**
     * Paint right side of pyramid.
     * @param height Board Height.
     * @return Pyramid painting.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Paint left side of pyramid.
     * @param height Board Height.
     * @return Pyramid painting.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Paint pyramid.
     * @param height Board Height.
     * @return Pyramid painting.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
