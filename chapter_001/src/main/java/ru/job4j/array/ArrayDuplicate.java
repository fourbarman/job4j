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
        int cutArray = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - cutArray; j++) {
                if (array[i].equals(array[j])) {
                    while (j != array.length - cutArray - 1
                            && array[array.length - cutArray - 1].equals(array[j])) {
                        cutArray++;
                    }
                    String temp = array[array.length - cutArray - 1];
                    array[array.length - cutArray - 1] = array[j];
                    array[j] = temp;
                    cutArray++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - cutArray);
    }
}
