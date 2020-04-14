package ru.job4j.lambda.School;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.lambda.school.School;
import ru.job4j.lambda.school.Student;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 14.04.2020
 */
public class SchoolTest {
    List<Student> list;
    School school;

    /**
     * Returns if score is in [70: 100].
     *
     * @return predicate.
     */
    public static Predicate<Student> is10A() {
        return p -> p.getScore() >= 70 && p.getScore() <= 100;
    }

    /**
     * Returns if score is in [50: 70).
     *
     * @return predicate.
     */
    public static Predicate<Student> is10B() {
        return p -> p.getScore() >= 50 && p.getScore() < 70;
    }

    /**
     * Returns if score is in (0: 50).
     *
     * @return predicate.
     */
    public static Predicate<Student> is10C() {
        return p -> p.getScore() > 0 && p.getScore() < 50;
    }

    /**
     * Set variables for test.
     */
    @Before
    public void setVar() {
        school = new School();
        list = List.of(
                new Student(15),
                new Student(50),
                new Student(60),
                new Student(70),
                new Student(80),
                new Student(99)
        );
    }

    /**
     * Test filter 10A.
     */
    @Test
    public void when10AStudents() {
        assertThat(school.collect(list, is10A()).size(), is(3));
    }

    /**
     * Test filter 10B.
     */
    @Test
    public void when10BStudents() {
        assertThat(school.collect(list, is10B()).size(), is(2));
    }

    /**
     * Test filter 10C.
     */
    @Test
    public void when10CStudents() {
        assertThat(school.collect(list, is10C()).size(), is(1));
    }
}
