package ru.job4j.collection.lexsort;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;
/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 26.03.2020
 */
public class LexSortTest {
    /**
     * Test when first string number is greater.
     */
    @Test
    public void compareTestFirstStringGreater() {
        LexSort lexSort = new LexSort();
        String s1 = "10. Task.";
        String s2 = "1. Task.";
        int result = lexSort.compare(s1, s2);
        assertThat(result, greaterThan(0));
    }
    /**
     * Test when first string number is less.
     */
    @Test
    public void compareTestFirstStringIsLess() {
        LexSort lexSort = new LexSort();
        String s1 = "1. Task.";
        String s2 = "15. Task.";
        int result = lexSort.compare(s1, s2);
        assertThat(result, lessThan(0));
    }
    /**
     * Test when first string number is equal.
     */
    @Test
    public void compareTestFirstStringEqualsSecond() {
        LexSort lexSort = new LexSort();
        String s1 = "1. Task.";
        String s2 = "1. Task.";
        int result = lexSort.compare(s1, s2);
        assertThat(result, is(0));
    }
    /**
     * Test when sort multiple strings.
     */
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}
