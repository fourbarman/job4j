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
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test show.
     */
    /**@Test
    public void whenUserAddCoupleItemsThenShowAll() {
        Tracker tracker = new Tracker();
        Input inputFirst = new StubInput(new String[] {"1", "firstItem", "firstDesc", "6"});
        Input inputSecond = new StubInput(new String[] {"1", "secondItem", "secondDesc", "7"});
        new StartUI(inputFirst, tracker).init();
        //new StartUI(inputSecond, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("firstItem"));
    }*/

    /**
     * Test replace.
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
}