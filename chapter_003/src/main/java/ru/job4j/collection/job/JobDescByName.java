package ru.job4j.collection.job;

import java.util.Comparator;

/**
 * JobDescByName.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 20.03.2020.
 */
public class JobDescByName implements Comparator<Job> {
    /**
     * Compares Job by name in descending order.
     * Returns 0 if objects equal.
     * Returns 1 if this object is greater.
     * Returns -1 if this object is less.
     *
     * @param o1 User.
     * @param o2 User.
     * @return int.
     */
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
