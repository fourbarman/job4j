package tracker;

import org.junit.Before;
import tracker.models.*;
import tracker.start.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 2
 * @since 27.08.2019
 */
public class TrackerTest {
    Tracker tracker;
    Item item1, item2, item3, item4;
    @Before
    public void setVar() {
        tracker = new Tracker();
        item1 = new Item("test1", "testDescription1", 1L);
        item2 = new Item("test2", "testDescription2", 12L);
        item3 = new Item("test3", "testDescription3", 123L);
        item4 = new Item("test4", "testDescription4", 1234L);
    }

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenStoresOneItem() {
        tracker.add(item1);
        assertThat(tracker.findAll().length, is(1));
    }

    /**
     * Test add.
     */
    @Test
    public void whenAddNewFourItemsThenStoresFourItems() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(tracker.findAll().length, is(4));
    }

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenThisItemIsStored() {
        tracker.add(item1);
        assertThat(tracker.findAll()[0], is(item1));
    }

    /**
     * Test replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        tracker.add(item1);
        item2.setId(item1.getId());
        tracker.replace(item1.getId(), item2);
        assertThat(tracker.findById(item1.getId()).getName(), is("test2"));
    }

    /**
     * Test findByName
     */
    @Test
    public void whenFindByNameUniqueThenFindOne() {
        String key = "t1";
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName(key).length, is(1));
    }
    /**
     * Test findByName
     */
    @Test
    public void whenFindByNameThenFindAll() {
        String key = "test";
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(tracker.findByName(key).length, is(4));
    }

    /**
     * Test findByName
     */
    @Test
    public void whenFindByNameThenFindStored() {
        String key = "t1";
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName(key)[0], is(item1));
    }

    /**
     * Test findByName when not found
     */
    @Test
    public void whenFindByNameThenFindNothing() {
        String key = "123";
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName(key), is(emptyArray()));
    }

    /**
     * Test findById
     */
    @Test
    public void whenFindByIdThenFindStored() {
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    /**
     * Test findById when found nothing
     */
    @Test
    public void whenFindByIdThenFoundNothing() {
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById("123"), is(nullValue()));
    }

    /**
     * Test delete
     */
    @Test
    public void whenDeleteSecondStoredItemArrayRebuilds() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll()[1], is(item3));
    }

    /**
     * Test delete when not found
     */
    @Test
    public void whenDeleteAndNotFound() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete("123");
        assertThat(tracker.findAll().length, is(4));
    }
}
