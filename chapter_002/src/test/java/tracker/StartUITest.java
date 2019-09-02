package tracker;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 13.08.2019
 */
public class StartUITest {
    Tracker tracker;
    Item item1, item2, item3, item4, item5;
    @Before
    public void setVar() {
        tracker = new Tracker();
        item1 = new Item("firstItem", "firstDescription");
        item2 = new Item("secondItem", "secondDescription");
        item3 = new Item("thirdItem", "thirdDescription");
        item4 = new Item("fourthItem", "fourthDescription");
        item5 = new Item("fifthItem", "fifthDescription");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
    }
    /**
     * Test add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
    Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
    new StartUI(input, tracker).init();
    assertThat(tracker.findAll()[tracker.findAll().length - 1].getName(), is("test name"));
    }
    /**
     * Test replace.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    /**
     * Test findAll.
     */
    @Test
    public void whenFindAllThenShowAllItems() {
        Item[] expected = new Item[]{item1, item2, item3, item4, item5};
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(expected));
    }
    /**
     * Test findByName
     */
    @Test
    public void whenSearchByIdThenFound() {
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
    /**
     * Test findByName
     */
    @Test
    public void whenSearchByNameThenFound() {
        Item[] expected = new Item[]{item2};
        Input input = new StubInput(new String[]{"4", "second", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("second"), is(expected));
    }
    /**
     * Test delete
     */
    @Test
    public void whenDeleteItemThenItemDeletes() {
        Item[] expected = new Item[]{item1, item3, item4, item5};
        Input input = new StubInput(new String[]{"5", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        tracker.delete(item2.getId());
        assertThat(tracker.findAll(), is(expected));
    }
}
