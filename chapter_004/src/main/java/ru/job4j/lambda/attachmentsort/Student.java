package ru.job4j.lambda.attachmentsort;

import java.util.Set;
/**
 * Student.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.04.2020.
 */
public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }
}
