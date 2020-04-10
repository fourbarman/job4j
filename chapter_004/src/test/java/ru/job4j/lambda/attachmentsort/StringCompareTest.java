package ru.job4j.lambda.attachmentsort;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 10.04.2020
 */
public class StringCompareTest {
    StringCompare stringCompare;
    List<String> list;

    @Before
    public void setVar() {
        stringCompare = new StringCompare();
        list = new ArrayList<>(Arrays.asList("one", "three", "five"));
    }

    /**
     * Test when compare in natural order.
     */
    @Test
    public void whenCompareNaturalOrder() {
        List expected = new ArrayList<>(Arrays.asList("five", "one", "three"));
        Collections.sort(list, stringCompare.cmpText);
        assertThat(list, is(expected));
    }

    /**
     * Test when compare descending size.
     */
    @Test
    public void whenCompareDescendingSize() {
        List expected = new ArrayList<>(Arrays.asList("three", "five", "one"));
        Collections.sort(list, stringCompare.cmpDescSize);
        assertThat(list, is(expected));
    }

    /**
     * Test when compare in natural order with out.
     */
    @Test
    public void whenCompareNaturalOrderOut() {
        List expected = new ArrayList<>(Arrays.asList("five", "one", "three"));
        Collections.sort(list, stringCompare.cmpTextOut);
        assertThat(list, is(expected));
    }

    /**
     * Test when compare descending size with out.
     */
    @Test
    public void whenCompareDescendingSizeOut() {
        List expected = new ArrayList<>(Arrays.asList("three", "five", "one"));
        Collections.sort(list, stringCompare.cmpDescSizeOut);
        assertThat(list, is(expected));
    }
}
