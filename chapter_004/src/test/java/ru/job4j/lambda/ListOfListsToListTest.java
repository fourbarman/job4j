package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 16.04.2020
 */
public class ListOfListsToListTest {
    /**
     * Test when List Of Lists Than One List Out.
     */
    @Test
    public void whenListOfListsThanOneListOut() {
        List<List<Integer>> list = List.of(
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7)
        );
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThat(new ListOfListsToList().doubleListToMap(list), is(expected));
    }
}
