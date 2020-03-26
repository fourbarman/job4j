package ru.job4j.collection.lexsort;

import java.util.Comparator;
/**
 * LexSort.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 26.03.2020.
 */
public class LexSort implements Comparator<String> {
    /**
     * Compare.
     * Return int < 0 if String left is less than String right.
     * Return int > 0 if String left is greater than String right.
     * Return int = 0 if String left is equal String right.
     * @param left String.
     * @param right String.
     * @return int.
     */
    @Override
    public int compare(String left, String right) {
        String leftString = left.substring(0, left.indexOf('.'));
        String rightString = right.substring(0, right.indexOf('.'));
        return Integer.compare(Integer.valueOf(leftString), Integer.valueOf(rightString));
    }
}
