package ru.job4j.collection.searchlinked;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 11.03.2020
 */
public class PriorityQueueTest {
    /**
     * Test priority queue.
     */
    @Test
    public void whenHigherPriority() {
        var expected = "urgent";
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is(expected));
    }
}
