package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 31.08.2018
 */
public class TurnTest {
    /**
     * Test turn.
     */
    @Test
    public void whenArray98765ThenTurnedArrayIs56789() {
        Turn turn = new Turn();
        int[] testArray = new int[]{5, 4, 3, 2, 1};
        int[] rst = turn.turn(testArray);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(rst, is(expect));
    }
    /**
     * Test turn when even.
     */
    @Test
    public void whenArray2614ThenTurnedArrayIs4162() {
        Turn turn = new Turn();
        int[] testArray = new int[]{2, 6, 1, 4};
        int[] rst = turn.turn(testArray);
        int[] expect = new int[]{4, 1, 6, 2};
        assertThat(rst, is(expect));
    }
}
