package ru.job4j.collection.job;

import java.util.Comparator;

/**
 * JobAscByPriority.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 20.03.2020.
 */
public class JobAscByPriority implements Comparator<Job> {
    /**
     * Compares Job by priority in ascending order.
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
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
