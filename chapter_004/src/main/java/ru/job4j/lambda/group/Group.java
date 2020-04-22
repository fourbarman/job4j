package ru.job4j.lambda.group;

import ru.job4j.lambda.attachmentsort.Student;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Group.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 21.04.2020.
 */
public class Group {
    /**
     * List of students converts to map grouped by sections.
     *
     * @param students List of Students.
     * @return Map.
     */
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream()
                        .map(unit -> new Group.Holder(unit, student.getName())))
                .collect(Collectors.groupingBy(
                        t -> t.key, Collector.of(
                                HashSet::new, (set, el) -> set.add(el.value),
                                (left, right) -> {
                                    left.addAll(right);
                                    return left;
                                }
                        )));
    }

    /**
     * Holder.
     *
     * @author fourbarman (maks.java@yandex.ru).
     * @version 1.
     * @since 21.04.2020.
     */
    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
