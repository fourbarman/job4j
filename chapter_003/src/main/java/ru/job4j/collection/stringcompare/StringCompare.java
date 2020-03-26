package ru.job4j.collection.stringcompare;

import java.util.Comparator;

/**
 * StringCompare.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 22.03.2020.
 */
public class StringCompare implements Comparator<String> {
    /**
     * Compares two strings.
     * Returns 0 if strings are equal.
     * Returns int > 0 if first string is greater.
     * Returns int < 0 if first string is less.
     *
     * @param left  First string.
     * @param right Second string.
     * @return int value.
     */
    @Override
    public int compare(String left, String right) {
        int index = 0;
        int result = 0;
        int l = Math.min(left.length(), right.length());
        int compare = Integer.compare(left.length(), right.length());
        while (index < l) {
            if (left.charAt(index) != right.charAt(index)) {
                result = Character.compare(left.charAt(index), right.charAt(index));
                break;
            }
            index++;
        }
        if (result == 0 && compare != 0) {
            return Integer.compare(compare, 0);
        }
        return result;
    }
}