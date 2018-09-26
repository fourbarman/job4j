package ru.job4j.array;

import java.util.Arrays;
/**
 * Third array from two arrays.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 26.09.2018.
 */

public class ThirdArray {
    /**
     * Loads elements from first array & second array to third array.
     * @param firstArray Array to analyse for duplicates.
     * @param secondArray Array to analyse for duplicates.
     * @return Final array.
     */
    public int[] thirdArr(int[] firstArray, int[] secondArray) {
        int[] third = new int[firstArray.length + secondArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            third[i] = firstArray[i];
        }
        for (int j = 0; j < secondArray.length; j++) {
            third[j + firstArray.length] = secondArray[j];
        }
        Arrays.sort(third);
        return third;
    }
}
