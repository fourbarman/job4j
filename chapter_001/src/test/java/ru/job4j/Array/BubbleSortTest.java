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
public class BubbleSortTest {
    /**
     * Test sort with 5 elements.
     */
    @Test
    public void whenArrayIs54321ThenSorted12345() {
        int[] array = new int[] {5, 1, 2, 7, 3};
        BubbleSort bs = new BubbleSort();
        int[] expected = new int[] {1, 2, 3, 5, 7};
        int[] sorted = bs.sort(array);
        assertThat(sorted, is(expected));
    }
    /**
     * Test sort with 10 elements.
     */
    @Test
    public void whenArrayIs9517382460ThenSorted12345() {
        int[] array = new int[] {9, 5, 1, 7, 3, 8, 2, 4, 6, 0};
        BubbleSort bs = new BubbleSort();
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sorted = bs.sort(array);
        assertThat(sorted, is(expected));
    }
}
