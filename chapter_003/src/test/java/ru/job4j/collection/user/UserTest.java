package ru.job4j.collection.user;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 20.03.2020
 */
public class UserTest {
    /**
     * Test when set in ascending order.
     */
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    /**
     * Test when object with name Petr is greater than object with name Ivan.
     */
    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    /**
     * Test when both object name are equal than compare by age.
     */
    @Test
    public void whenComparePertVSPetrThanCompareByAge() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Petr", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
}