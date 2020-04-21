package ru.job4j.lambda.group;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.lambda.attachmentsort.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 21.04.2020
 */
public class GroupTest {
    List<Student> list;

    /**
     * Test when found by name.
     */
    @Before
    public void setVar() {
        list = List.of(
                new Student("Ivan", Set.of("sect1", "sect2", "sect3")),
                new Student("Petr", Set.of("sect1")),
                new Student("Stepan", Set.of("sect2")),
                new Student("Sveta", Set.of("sect3")),
                new Student("Olga", Set.of("sect1", "sect2")),
                new Student("Anna", Set.of("sect2", "sect3"))
        );
    }

    /**
     * Test when list of students converts to map grouped by sections.
     */
    @Test
    public void whenThreeSectionsThanMapHasSizeThree() {
        assertThat(Group.sections(list).size(), is(3));
    }

    /**
     * Test when Set of sections contains null.
     */
    @Test
    public void whenNullInThreeSectionsThanMapHasSizeTwo() {
        Set<String> sect = new HashSet<>();
        sect.add("sect1");
        sect.add(null);
        sect.add("sect3");
        List<Student> listWithNull = List.of(new Student("Ivan", sect));
        assertThat(Group.sections(listWithNull).size(), is(2));
    }
}
