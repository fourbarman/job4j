package ru.job4j.collection.convertlist;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertList.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 12.03.2020.
 */
public class ConvertList {
    /**
     * Returns list of integers from incoming list of arrays of integers.
     *
     * @param list Incoming list of int arrays.
     * @return 2D array.
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] arr : list) {
            for (int i : arr) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}
