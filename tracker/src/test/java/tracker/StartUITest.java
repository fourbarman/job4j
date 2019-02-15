package tracker;

import tracker.models.*;
import tracker.start.*;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    /**
     * Test Add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test showAll.
     */

    @Test
    public void whenUserAddCoupleItemsThenShowAll() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {
                "0", "first name", "first desc",
                "0", "second name", "second desc",
                "1",
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("first name"));
        assertThat(tracker.findAll()[1].getName(), is("second name"));

    }

    /**
     * Test edit.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Task("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNoItemWithSameName() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item itemFirst = tracker.add(new Task("first name", "first desc"));
        //Напрямую добавляем заявку
        Item itemSecond = tracker.add(new Task("second name", "second desc"));
        Input input = new StubInput(new String[]{
                "3", itemFirst.getId(),
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(itemSecond));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenHasStoredThenFoundByID() {
        Tracker tracker = new Tracker();
        Item itemFirst = tracker.add(new Task("first name", "first desc"));
        Item itemSecond = tracker.add(new Task("second name", "second desc"));
        Input input = new StubInput(new String[]{
                "4", itemSecond.getId(),
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(itemSecond.getId()), is(itemSecond));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenHasStoredThenFoundByName() {
        Tracker tracker = new Tracker();
        String key = "searching";
        Item itemFirst = tracker.add(new Task("searching name", "first desc"));
        Item itemSecond = tracker.add(new Task("second name", "second desc"));
        Input input = new StubInput(new String[]{
                "5", key,
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(key)[0], is(itemFirst));
    }
}