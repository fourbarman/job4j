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
public class MatrixTest {
    /**
     * Test multiple with for size 2.
     */
    @Test
    public void whenSize2ThenTable2x2() {
        int size = 2;
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(size);
        int[][] expected = new int[][] {{1, 2},
                                        {2, 4}
        };
        assertThat(table, is(expected));
    }
    /**
     * Test multiple with for size 4.
     */
    @Test
    public void whenSize2ThenTable4x4() {
        int size = 4;
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(size);
        int[][] expected = new int[][] {{1, 2, 3, 4},
                                        {2, 4, 6, 8},
                                        {3, 6, 9, 12},
                                        {4, 8, 12, 16}
        };
        assertThat(table, is(expected));
    }
}
