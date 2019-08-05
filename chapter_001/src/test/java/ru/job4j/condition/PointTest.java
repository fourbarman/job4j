package ru.job4j.condition;


import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 24.08.2018
 */
public class PointTest {
    /**
     * Test distanceTo().
     */
    @Test
    public void distancePointAToPointB() {
        Point a = new Point(0, 2);
        Point b = new Point(2, 0);
        double result = a.distanceTo(b);
        double expected = 2.8D;
        assertThat(result, closeTo(expected, 0.1));
    }
    /**
     * Test distance3d().
     */
    @Test
    public void distancePointAtoPointBIn3D() {
        Point a = new Point(0, 0, 2);
        Point b = new Point(2, 2, 2);
        double result = a.distance3d(b);
        double expected = 2.83D;
        assertThat(result, closeTo(expected, 0.1));
    }
}

