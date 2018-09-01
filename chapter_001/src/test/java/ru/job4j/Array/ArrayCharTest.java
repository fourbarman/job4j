package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 01.09.2018
 */
public class ArrayCharTest {
    /**
     * Test startWith when true.
     */
    @Test
    public void ifArrayStartsWithPrefixThenTrue() {
        ArrayChar ac = new ArrayChar("Hello");
        boolean result = ac.startWith("He");
        assertThat(result, is(true));
    }
    /**
     * Test startWith when false.
     */
    @Test
    public void ifArrayNotStartsWithPrefixThenFalse() {
        ArrayChar ac = new ArrayChar("Hello");
        boolean result = ac.startWith("Hi");
        assertThat(result, is(false));
    }
}
