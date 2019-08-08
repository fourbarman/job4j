package ru.job4j.condition;

/**
 * Point.
 *
 * @author fourbarman (maks.java@yandex.ru)
 * @version 2
 * @since 05.08.2019
 */
public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Calculate distance between point this to point that in 2 dimensions.
     * @param that point that.
     * @return distance.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
    /**
     * Calculate distance between point this to point that in 3 dimensions.
     * @param that point that.
     * @return distance.
     */
    public double distance3d(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2) + Math.pow(this.z - that.z, 2)
        );
    }
}
