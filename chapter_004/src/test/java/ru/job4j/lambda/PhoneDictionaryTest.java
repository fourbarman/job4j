package ru.job4j.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 14.04.2020
 */
public class PhoneDictionaryTest {
    /**
     * Test when found by name.
     */
    @Test
    public void whenFindByName() {
        var key = "etr";
        var expected = "Arsentev";
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find(key);
        assertThat(persons.get(0).getSurname(), is(expected));
    }

    /**
     * Test when Not found.
     */
    @Test
    public void whenNotFoundByName() {
        var key = "zzz";
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find(key);
        assertThat(persons.isEmpty(), is(true));
    }
}
