package ru.job4j.lambda.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * School.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 14.04.2020
 */
public class School {
    /**
     * Filters incoming list with predicate and returns result.
     *
     * @param students List of students.
     * @param predict  Predicate.
     * @return list.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
