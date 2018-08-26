package ru.job4j.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 23.08.2018
 */
public class FactorialTest {
    /**
     * Test count when n value is five.
     */
    @Test
    public void whenNValueIsFiveThenFactorialIs120() {
        Factorial factor = new Factorial();
        int result = factor.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test count when n value is zero.
     */
    @Test
    public void whenNValueIsZeroThenFactorialIsOne() {
        Factorial factor = new Factorial();
        int result = factor.calc(0);
        assertThat(result, is(1));
    }

}
