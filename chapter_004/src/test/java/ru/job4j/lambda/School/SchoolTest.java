package ru.job4j.lambda.School;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.lambda.school.School;
import ru.job4j.lambda.school.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    List<Student> list, listWithNulls;
    School school;

    /**
     * Set variables for test.
     */
    @Before
    public void setVar() {
        school = new School();
        list = List.of(
                new Student("Ivanov", "Ivan", 15, 3),
                new Student("Ivanov", "Ivan", 15, 4),
                new Student("Petrov", "Petr", 50, 5),
                new Student("Sidorov", "Sidor", 60, 6),
                new Student("Ivanova", "Ivana", 70, 7),
                new Student("Petrova", "Petra", 80, 8),
                new Student("Sidorova", "Sidra", 99, 9)
        );
        listWithNulls = new ArrayList<>(Arrays.asList(
                new Student("Ivanov", "Ivan", 15, 3),
                null,
                new Student("Petrov", "Petr", 50, 5),
                null,
                new Student("Ivanova", "Ivana", 70, 7),
                null,
                new Student("Sidorova", "Sidra", 99, 9)
        ));
    }

    /**
     * Test filter 10A.
     */
    @Test
    public void when10AStudents() {
        assertThat(school.collect(list, p -> p.getScore() >= 70 && p.getScore() <= 100).size(), is(3));
    }

    /**
     * Test filter 10B.
     */
    @Test
    public void when10BStudents() {
        assertThat(school.collect(list, p -> p.getScore() >= 50 && p.getScore() < 70).size(), is(2));
    }

    /**
     * Test filter 10C.
     */
    @Test
    public void when10CStudents() {
        assertThat(school.collect(list, p -> p.getScore() > 0 && p.getScore() < 50).size(), is(2));
    }

    /**
     * Test size when students to map.
     */
    @Test
    public void whenSixStudentsToMapThanMapSizeIsSix() {
        assertThat(school.collectStuds(list).size(), is(6));
    }

    /**
     * Test size when students score more than bound.
     */
    @Test
    public void whenSixStudentsScoreMoreThanBound() {
        assertThat(school.levelOf(list, 5).size(), is(5));
    }

    /**
     * Test size when students score more than bound. List With nulls.
     */
    @Test
    public void whenSixStudentsScoreMoreThanBoundWithNulls() {
        assertThat(school.levelOf(listWithNulls, 5).size(), is(3));
    }
}
