package ru.job4j.collection.departments;

import java.util.Comparator;

/**
 * DepDescComp.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 02.04.2020.
 */
public class DepDescComp implements Comparator<String> {

    /**
     * Compares two strings.
     * Returns 0 if strings are equal.
     * Returns int > 0 if first string is greater.
     * Returns int < 0 if first string is less.
     *
     * @param o1 First string.
     * @param o2 Second string.
     * @return int value.
     */
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int result = second[0].compareTo(first[0]);
        if (result == 0) {
            result = o1.compareTo(o2);
        }
        return result;
    }
}
