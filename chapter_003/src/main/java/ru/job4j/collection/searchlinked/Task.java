package ru.job4j.collection.searchlinked;

/**
 * Task.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 05.03.2020.
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
