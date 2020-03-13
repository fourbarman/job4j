package ru.job4j.searchlinked;

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
            if (task.getPriority() >= element.getPriority()) {
                index++;
            } else {
                break;
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * Returns first task with index = 0 and than removes it.
     *
     * @return task.
     */
    public Task take() {
        return tasks.remove(0);
    }
}
