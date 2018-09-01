package ru.job4j.array;
/**
 * Array bubble sort.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.09.2018.
 */
public class BubbleSort {
    /**
     * Sorts array.
     * @param array Array to sort.
     * @return Sorted array.
     */
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
