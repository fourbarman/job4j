package ru.job4j.collection.job;

import java.util.Comparator;

/**
 * JobAscByName.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 20.03.2020.
 */
public class JobAscByName implements Comparator<Job> {
    /**
     * Compares Job by name in ascending order.
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
        return o1.getName().compareTo(o2.getName());
    }
}
