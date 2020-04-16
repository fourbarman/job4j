package ru.job4j.lambda;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ListOfListsToList.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.04.2020.
 */
public class ListOfListsToList {
    /**
     * Converts list of lists to list.
     *
     * @param matrix List of lists.
     * @return List.
     */
    public List<Integer> doubleListToMap(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
