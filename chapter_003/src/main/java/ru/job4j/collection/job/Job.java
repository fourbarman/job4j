package ru.job4j.collection.job;

/**
 * Job.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 21.03.2020.
 */
public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    /**
     * Constructor.
     */
    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    /**
     * Return name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Return priority.
     *
     * @return priority.
     */

    public int getPriority() {
        return priority;
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        return "Job{" + name + ", " + priority + '}';
    }

    /**
     * Compares job by priority.
     * Returns 0 if objects equal.
     * Returns 1 if this object is greater.
     * Returns -1 if this object is less.
     *
     * @param another Job.
     * @return int.
     */
    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
