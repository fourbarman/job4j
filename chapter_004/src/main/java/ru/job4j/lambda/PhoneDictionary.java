package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * PhoneDictionary.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 14.04.2020.
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    /**
     * Add Person to list.
     *
     * @param person To add.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Search Person by key and return list of found.
     *
     * @param key Key.
     * @return List.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> (
                person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getAddress().contains(key)
                        || person.getPhone().contains(key)
        );
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
