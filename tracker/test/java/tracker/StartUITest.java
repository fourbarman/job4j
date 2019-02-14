package tracker;

import tracker.models.*;
import tracker.start.*;

import org.junit.Test;


import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    /**
     * Test Add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        //Item itemFirst = tracker.add(new Task("first", "firstDesc"));
        //Item itemSecond = tracker.add(new Task ("second", "secondDesc"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("first name"));
        assertThat(tracker.findAll()[1].getName(), is("second name"));

    }

    /**
     * Test edit.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Task("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNoItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{
                "0", "first name", "first desc",
                "0", "to delete name", "to delete desc",
                "3", tracker.findAll()[1].getId(),
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[1].getId(), is(nullValue()));
    }
}