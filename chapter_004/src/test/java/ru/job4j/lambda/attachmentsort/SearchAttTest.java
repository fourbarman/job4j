package ru.job4j.lambda.attachmentsort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 10.04.2020
 */
public class SearchAttTest {
    private List<Attachment> list;
    Attachment at1, at2, at3, at4, at5, at6;

    @Before
    public void setVar() {
        at1 = new Attachment("pic1", 10);
        at2 = new Attachment("pic2", 100);
        at3 = new Attachment("bug", 120);
        at4 = new Attachment("pic4", 130);
        at5 = new Attachment("pic5", 1000);
        at6 = new Attachment("bug", 10);
        list = new ArrayList<>(Arrays.asList(at1, at2, at3, at4, at5, at6));
    }

    /**
     * Test when Search By Size.
     */
    @Test
    public void whenSearchBySize() {
        assertThat(SearchAtt.filterSize(list), is(List.of(at3, at4, at5)));
    }

    /**
     * Test when Search By Name.
     */
    @Test
    public void whenSearchByName() {
        assertThat(SearchAtt.filterName(list), is(List.of(at3, at6)));
    }
}
