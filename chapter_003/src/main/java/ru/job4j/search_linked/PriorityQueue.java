package ru.job4j.search_linked;

import java.util.LinkedList;

/**
 * PriorityQueue.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 05.03.2020.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() >= tasks.size()) {
                index = tasks.size() - 1;
            } else {
                index = element.getPriority();
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.remove(0);
    }
}
