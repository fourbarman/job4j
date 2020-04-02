package ru.job4j.collection.departments;

import java.util.*;

/**
 * Departments.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 02.04.2020.
 */
public class Departments {
    /**
     * Fills List with unique strings from input list, splitted with "/".
     *
     * @param deps List of Strings.
     * @return Filled List.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start == "") {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        List<String> result = new ArrayList<>(tmp);
        sortAsc(result);
        return result;
    }

    /**
     * Sorts List in ascending order.
     *
     * @param orgs List of Strings.
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    /**
     * Sorts List in descending order.
     *
     * @param orgs List of Strings.
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
