package ru.job4j.fullsearch;

import java.util.HashSet;
import java.util.List;
/**
 * FullSearch.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.03.2020.
 */
public class FullSearch {
    /**
     * Returns hash set from list of numbers.
     *
     * @return numbers.
     */
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : list) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}
