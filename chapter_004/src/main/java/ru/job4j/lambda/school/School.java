package ru.job4j.lambda.school;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * Returns map <surname, name>.
     *
     * @param students List of students.
     * @return map.
     */
    public Map<String, String> collectStuds(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getSurname, Student::getSurname, (surname1, surname2) -> surname1)
        );
    }

    /**
     * Returns list of studs having scope > bound.
     *
     * @param students List of students.
     * @return List.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .dropWhile(s -> s.getScope() < bound)
                .collect(Collectors.toList());
    }
}
