package ru.job4j.collection.job;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 21.03.2020
 */
public class JobTest {
    /**
     * Test when Comparator by name descending order.
     */
    @Test
    public void whenComparatorByNameDescending() {
        Comparator<Job> cmpNameDescending = new JobDescByName();
        int rsl = cmpNameDescending.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    /**
     * Test when Comparator by name ascending order.
     */
    @Test
    public void whenComparatorByNameAscending() {
        Comparator<Job> cmpNameAscending = new JobAscByName();
        int rsl = cmpNameAscending.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    /**
     * Test when Comparator by priority ascending order.
     */
    @Test
    public void whenComparatorByPriorityAscending() {
        Comparator<Job> cmpPriorityAscending = new JobAscByPriority();
        int rsl = cmpPriorityAscending.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    /**
     * Test when Comparator by priority descending order.
     */
    @Test
    public void whenComparatorByPriorityDescending() {
        Comparator<Job> cmpPriorityDescending = new JobDescByPriority();
        int rsl = cmpPriorityDescending.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    /**
     * Test when Comparator by name and priority ascending order.
     */
    @Test
    public void whenComparatorByNameAndPriorityAscending() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    /**
     * Test when Comparator by name and priority descending order.
     */
    @Test
    public void whenComparatorByNameAndPriorityDescending() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    /**
     * Test when Comparator by priority and by name ascending order.
     */
    @Test
    public void whenComparatorByPriorityAndByNameAscending() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    /**
     * Test when Comparator by priority and by name ascending order.
     */
    @Test
    public void whenComparatorByPriorityAndByNameDescending() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    /**
     * Test when Comparator by priority and by name ascending order and names equal.
     */
    @Test
    public void whenComparatorByNameAndByPriorityDescAndNamesEqual() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    /**
     * Test when Comparator by priority and by name ascending order, names and priorities equal.
     */
    @Test
    public void whComparatorByNameAndByPriorityNamesAndPrioritiesEqual() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, is(0));
    }
}