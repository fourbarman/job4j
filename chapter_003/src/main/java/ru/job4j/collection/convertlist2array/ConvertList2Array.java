package ru.job4j.collection.convertlist2array;

import java.util.Arrays;
import java.util.List;

/**
 * ConvertList2Array.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 12.03.2020.
 */
public class ConvertList2Array {
    /**
     * Returns array of integers in 2D format with number of rows.
     *
     * @param list  Incoming list of integers.
     * @param cells Required number of rows.
     * @return 2D array.
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell] = num;
            cell++;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
