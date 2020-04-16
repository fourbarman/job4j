package ru.job4j.lambda.School;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.lambda.school.School;
import ru.job4j.lambda.school.Student;

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
    List<Student> list;
    School school;

    /**
     * Set variables for test.
     */
    @Before
    public void setVar() {
        school = new School();
        list = List.of(
                new Student("Ivanov", "Ivan", 15),
                new Student("Petrov", "Petr", 50),
                new Student("Sidorov", "Sidor", 60),
                new Student("Ivanova", "Ivana", 70),
                new Student("Petrova", "Petra", 80),
                new Student("Sidorova", "Sidra", 99)
        );
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
        assertThat(school.collect(list, p -> p.getScore() > 0 && p.getScore() < 50).size(), is(1));
    }

    /**
     * Test size when students to map.
     */
    @Test
    public void whenSixStudentsToMapThanMapSizeIsSix() {
        assertThat(school.collectStuds(list).size(), is(6));
    }
}
