package ru.job4j.lambda.attachmentsort;


import java.util.*;
import java.util.function.Function;

import static java.util.Collections.sort;
/**
 * FI.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.04.2020.
 */
public class FI {
    public static void raw(List<Student> list, Function<Student, Mark> func) {
        for (Student att : list) {
            func.apply(att);
        }
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("name 1", new HashSet<>(Arrays.asList("a", "b"))),
                        new Student("name 3", new HashSet<>(Arrays.asList("a", "b"))),
                        new Student("name 2", new HashSet<>(Arrays.asList("a", "b")))));

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Function<Student, Mark> func = new Function<Student, Mark>() {

            @Override
            public Mark apply(Student Student) {
                return null;
            }
        };
        sort(students, comparator);
        for (Student std : students) {
            System.out.println(std.getName());
        }
    }
}
