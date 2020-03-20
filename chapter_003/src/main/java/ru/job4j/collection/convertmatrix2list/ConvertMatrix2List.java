package ru.job4j.collection.convertmatrix2list;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMatrix2List.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 12.03.2020.
 */
public class ConvertMatrix2List {
    /**
     * Returns list from 2D array of integers.
     *
     * @param array Incoming 2D array of integers.
     * @return List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
