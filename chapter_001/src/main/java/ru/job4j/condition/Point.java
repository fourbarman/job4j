package ru.job4j.condition;

/**
 * Point.
 *
 * @author fourbarman (maks.java@yandex.ru)
 * @version 1
 * @since 22.08.2018
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate distance between point this to point that.
     * @param that point that.
     * @return distance.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}
