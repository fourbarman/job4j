package ru.job4j.fit;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 17.08.2018
 */
public class FitTest {

    /**
     * Test manWeight.
     */
    @Test
    public void whenManHeight180ThenWeightCloseTo92() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Test womanWeight.
     */
    @Test
    public void whenWomanHeight170ThenWeightCloseTo69() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}