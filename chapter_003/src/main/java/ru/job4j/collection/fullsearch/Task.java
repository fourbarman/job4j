package ru.job4j.collection.fullsearch;

/**
 * Task.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.03.2020.
 */
public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }
}
