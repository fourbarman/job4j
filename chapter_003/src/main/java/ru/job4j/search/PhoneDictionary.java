package ru.job4j.search;

import java.util.ArrayList;

/**
 * PhoneDictionary.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 05.03.2020.
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.getAddress().contains(key)
                    || p.getName().contains(key)
                    || p.getPhone().contains(key)
                    || p.getSurname().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}
