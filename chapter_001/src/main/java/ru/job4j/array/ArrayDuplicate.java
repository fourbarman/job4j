package ru.job4j.array;

import java.util.Arrays;
/**
 * Duplicate array.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 03.09.2018.
 */
public class ArrayDuplicate {
    /**
     * Removes duplicates in array.
     * @param array Array to analyse for duplicates.
     * @return Array without duplicates.
     */
    public String[] remove(String[] array) {
        int cutArray = array.length;
        for (int i = 0; i < cutArray; i++) {
            for (int j = i + 1; j < cutArray; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[cutArray - 1];
                    cutArray--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, cutArray);
    }
}
