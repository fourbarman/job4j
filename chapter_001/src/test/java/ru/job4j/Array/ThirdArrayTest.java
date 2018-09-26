package ru.job4j.array;

import org.junit.Test;
import ru.job4j.array.ThirdArray;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThirdArrayTest {
    /**
     * Test thirdArr When Length And Elements Are Not Equal.
     */
    @Test
    public void returnArrayWhenLengthAndElementsNotEqual() {
        int[] firstArray = new int[] {1, 2, 3, 4, 5};
        int[] secondArray = new int[] {9, 8, 7, 6};
        ThirdArray ta = new ThirdArray();
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] thirdArray = ta.thirdArr(firstArray, secondArray);
        assertThat(thirdArray, is(expected));
    }
    /**
     * Test thirdArr When Length Equal.
     */
    @Test
    public void returnArrayWhenLengthEqual() {
        int[] firstArray = new int[] {1, 2, 3, 4, 5};
        int[] secondArray = new int[] {10, 9, 8, 7, 6};
        ThirdArray ta = new ThirdArray();
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] thirdArray = ta.thirdArr(firstArray, secondArray);
        assertThat(thirdArray, is(expected));
    }
    /**
     * Test thirdArr When Elements In Arrays Are Equal.
     */
    @Test
    public void returnArrayWhenElementsInArraysEqual() {
        int[] firstArray = new int[] {1, 2, 3, 4, 5};
        int[] secondArray = new int[] {1, 2, 3, 4, 5};
        ThirdArray ta = new ThirdArray();
        int[] expected = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] thirdArray = ta.thirdArr(firstArray, secondArray);
        assertThat(thirdArray, is(expected));
    }
    /**
     * Test thirdArr When Elements Equal.
     */
    @Test
    public void returnArrayWhenElementsEqual() {
        int[] firstArray = new int[] {1, 1, 1, 1, 1};
        int[] secondArray = new int[] {1, 1, 1, 1, 1};
        ThirdArray ta = new ThirdArray();
        int[] expected = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] thirdArray = ta.thirdArr(firstArray, secondArray);
        assertThat(thirdArray, is(expected));
    }
}
