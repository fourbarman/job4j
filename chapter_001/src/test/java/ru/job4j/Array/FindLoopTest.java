package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 30.08.2018
 */
public class FindLoopTest {
    /**
     * Test findLoop.
     */
    @Test
    public void whenElIs5ThenIndex3() {
        int[] data = new int[] {1, 2, 4, 5, 8};
        int el = 5;
        int expect = 3;
        FindLoop fl = new FindLoop();
        int result = fl.findLoop(data, el);
        assertThat(result, is(expect));
    }
    /**
     * Test findLoop.
     */
    @Test
    public void whenElIsNotFound() {
        int[] data = new int[] {1, 2, 4, 5, 8};
        int el = 3;
        int expect = -1;
        FindLoop fl = new FindLoop();
        int result = fl.findLoop(data, el);
        assertThat(result, is(expect));
    }
}
