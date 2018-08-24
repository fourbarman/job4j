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
     * Test add.
     */
    @Test
    public void distancePointAToPointB(){
        Point a = new Point(0, 2);
        Point b = new Point(2, 0);
        double result = a.distanceTo(b);
        double expected = 2.8D;
        assertThat(result, closeTo(expected, 0.1));
    }
}

