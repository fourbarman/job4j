package tracker;

import tracker.models.*;
import tracker.start.*;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 29.10.2018
 */
public class TrackerTest {

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test findByName
     */
    @Test
    public void whenFindByNameThenFindStored() {
        String key = "tes";
        Tracker tracker = new Tracker();
        Item stored = new Item("test", "testDescription", 12L);
        Item storedSecond = new Item("te", "testDescription", 123L);
        tracker.add(stored);
        tracker.add(storedSecond);
        tracker.findByName(key);
        assertThat(tracker.findAll()[0], is(stored));
    }
    /**
     * Test findByName when not found
     */
    @Test
    public void whenFindByNameThenFindNothing() {
        String key = "123";
        Tracker tracker = new Tracker();
        Item stored = new Item("test", "testDescription", 12L);
        Item storedSecond = new Item("te", "testDescription", 123L);
        tracker.add(stored);
        tracker.add(storedSecond);
        Item[] result = tracker.findByName(key);
        assertThat(result.length, is(0));
    }

    /**
     * Test findById
     */
    @Test
    public void whenFindByIdThenFindStored() {
        Tracker tracker = new Tracker();
        Item storedItemOne = new Item("test1", "testDescription", 123L);
        Item storedItemTwo = new Item("test2", "testDescription2", 1234L);
        tracker.add(storedItemOne);
        tracker.add(storedItemTwo);
        assertThat(tracker.findById(storedItemOne.getId()), is(storedItemOne));
    }

    /**
     * Test findById when found nothing
     */
    @Test
    public void whenFindByIdThenFoundNothing() {
        Tracker tracker = new Tracker();
        Item storedItemOne = new Item("test1", "testDescription", 123L);
        Item storedItemTwo = new Item("test2", "testDescription2", 1234L);
        tracker.add(storedItemOne);
        tracker.add(storedItemTwo);
        assertThat(tracker.findById("123"), is(nullValue()));
    }

    /**
     * Test delete
     */
    @Test
    public void whenDeleteSecondStoredItemArrayRebuilds() {
        Tracker tracker = new Tracker();
        Item storedItemOne = new Item("test1", "testDescription1", 1L);
        Item storedItemTwo = new Item("test2", "testDescription2", 12L);
        Item storedItemThree = new Item("test3", "testDescription3", 123L);
        Item storedItemFour = new Item("test4", "testDescription4", 1234L);
        tracker.add(storedItemOne);
        tracker.add(storedItemTwo);
        tracker.add(storedItemThree);
        tracker.add(storedItemFour);
        tracker.delete(storedItemTwo.getId());
        assertThat(tracker.findAll()[1], is(storedItemThree));
    }
}
