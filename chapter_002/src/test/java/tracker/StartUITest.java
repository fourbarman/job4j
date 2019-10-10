package tracker;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version $Id$
 * @since 03.09.2019
 */
public class StartUITest {
    Tracker tracker;
    Item item1, item2, item3, item4, item5;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String showMenu =
            "MENU" + System.lineSeparator()
                    + "0. Add new item" + System.lineSeparator()
                    + "1. Show all items" + System.lineSeparator()
                    + "2. Edit item" + System.lineSeparator()
                    + "3. Find items by Id" + System.lineSeparator()
                    + "4. Find item by name" + System.lineSeparator()
                    + "5. Delete item" + System.lineSeparator()
                    + "6. Exit" + System.lineSeparator();

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
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void loadStdOutput() {
        System.setOut(new PrintStream(this.stdout));
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
     * Test replace.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "replaced item", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    /**
     * Test findById
     */
    @Test
    public void whenSearchByIdThenFound() {
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
    /**
     * Test findByName.
     */
    @Test
    public void whenSearchByNameThenFound() {
        Item[] expected = new Item[]{item2};
        Input input = new StubInput(new String[]{"4", "second", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("second"), is(expected));
    }
    /**
     * Test delete.
     */
    @Test
    public void whenDeleteItemThenItemDeletes() {
        Item[] expected = new Item[]{item1, item3, item4, item5};
        Input input = new StubInput(new String[]{"5", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        tracker.delete(item2.getId());
        assertThat(tracker.findAll(), is(expected));
    }
    /**
     * Test add action.
     * Check user output.
     */
    @Test
    public void whenAddItemThanHasItem() {
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(showMenu)
                .append("------------ Add new Item ------------")
                .append(System.lineSeparator())
                .append("------------ ")
                .append("New item added with Id: ")
                .append(tracker.findAll()[tracker.findAll().length - 1].getId())
                .append("------------")
                .append(System.lineSeparator())
                .append(showMenu)
                .toString()));
    }
    /**
     * Test findAll action.
     * Check user output.
     */
    @Test
    public void whenFindAllItems() {
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder sb = new StringBuilder();
        sb.append(showMenu)
                .append("------------ All items ------------")
                .append(System.lineSeparator());
        for (int i = 0; i < tracker.findAll().length; i++) {
            sb.append("Item's ID: ")
                    .append(tracker.findAll()[i].getId())
                    .append(" Item's name: ")
                    .append(tracker.findAll()[i].getName())
                    .append(" Description: ")
                    .append(tracker.findAll()[i].getDesc())
                    .append(" Birth time: ")
                    .append(tracker.findAll()[i].getTime())
                    .append(System.lineSeparator());
        }
        sb.append(showMenu);
        assertThat(this.out.toString(), is(sb.toString()));
    }
    /**
     * Test replace action.
     * Check user output.
     */
    @Test
    public void whenReplaceItem() {
        Item item = tracker.findAll()[2];
        Input input = new StubInput(new String[] {"2", item.getId(), "replaced name", "replaced desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(showMenu)
                .append("------------ Replace item ------------")
                .append(System.lineSeparator())
                .append("Item's ID: ")
                .append(item.getId())
                .append(" Item's name: ")
                .append(item.getName())
                .append(" Description: ")
                .append(item.getDesc())
                .append(" Birth time: ")
                .append(item.getTime())
                .append(System.lineSeparator())
                .append("Item's ID: ")
                .append(tracker.findAll()[2].getId())
                .append(" Item's name: ")
                .append(tracker.findAll()[2].getName())
                .append(" Description: ")
                .append(tracker.findAll()[2].getDesc())
                .append(" Birth time: ")
                .append(tracker.findAll()[2].getTime())
                .append(System.lineSeparator())
                .append(showMenu)
                .toString()));
    }
    /**
     * Test findId action.
     * Check user output.
     */
    @Test
    public void whenFindById() {
        String id = item3.getId();
        Input input = new StubInput(new String[] {"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(showMenu)
                .append("------------ Found item ------------")
                .append(System.lineSeparator())
                .append("Item's ID: ")
                .append(item3.getId())
                .append(" Item's name: ")
                .append(item3.getName())
                .append(" Description: ")
                .append(item3.getDesc())
                .append(" Birth time: ")
                .append(item3.getTime())
                .append(System.lineSeparator())
                .append(showMenu)
                .toString()));
    }
    /**
     * Test findByName action.
     * Check user output.
     */
    @Test
    public void whenFindByName() {
        String name = item2.getName();
        Input input = new StubInput(new String[] {"4", name, "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder().append(showMenu)
                .append("Found items: ")
                .append(System.lineSeparator())
                .append("Item's ID: ")
                .append(item2.getId())
                .append(" Item's name: ")
                .append(item2.getName())
                .append(" Description: ")
                .append(item2.getDesc())
                .append(" Birth time: ")
                .append(item2.getTime())
                .append(System.lineSeparator())
                .append(showMenu)
                .toString()));
    }
    /**
     * Test deleteItem action.
     * Check user output.
     */
    @Test
    public void whenDeleteItem() {
        String id = item2.getId();
        Input input = new StubInput(new String[] {"5", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder().append(showMenu)
                .append("Item with ")
                .append(id)
                .append(" deleted!")
                .append(System.lineSeparator())
                .append(showMenu)
                .toString()));
    }
}
