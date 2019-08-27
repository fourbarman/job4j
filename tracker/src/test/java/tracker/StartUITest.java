package tracker;

import org.junit.After;
import org.junit.Before;
import tracker.models.*;
import tracker.start.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version $Id$
 * @since 27.08.2019
 */
public class StartUITest {
    private Tracker tracker;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String showMenu =
            "MENU" + System.lineSeparator()
            + "0. Add new Item" + System.lineSeparator()
            + "1. Show all Items" + System.lineSeparator()
            + "2. Edit item" + System.lineSeparator()
            + "3. Delete Item" + System.lineSeparator()
            + "4. Find item by Id" + System.lineSeparator()
            + "5. Find items by name" + System.lineSeparator()
            + "6. Exit program" + System.lineSeparator();

    @Before
    public void loadOutput() {
        tracker = new Tracker();
        tracker.add(new Task("first name", "first desc"));
        tracker.add(new Task("second name", "second desc"));
        tracker.add(new Task("third name", "third desc"));
        tracker.add(new Task("fourth name", "fourth desc"));
        tracker.add(new Task("fifth name", "fifth desc"));
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Test Add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[tracker.findAll().length - 1].getName(), is("test name"));
    }

    /**
     * Test showAll.
     */
    @Test
    public void whenUserAddCoupleItemsThenShowAll() {
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("first name"));
        assertThat(tracker.findAll()[1].getName(), is("second name"));

    }

    /**
     * Test edit.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
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
        Item expected = tracker.findAll()[1];
        Item toDelete = tracker.findAll()[0];
        Input input = new StubInput(new String[]{
                "3", toDelete.getId(),
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(expected));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenHasStoredThenFoundByID() {
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
        String key = "third";
        Input input = new StubInput(new String[]{
                "5", key,
                "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(key)[0], is(tracker.findAll()[2]));
    }

    /**
     * Test Add action.
     */
    @Test
    public void whenUserAddItemThen() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(showMenu)
                        .append("------------ Добавление новой заявки --------------")
                        .append(System.lineSeparator())
                        .append("------------ Создана новая заявка с Id : ").append(tracker.findAll()[tracker.findAll().length - 1].getId()).append("-----------")
                        .append(System.lineSeparator())
                        .append("-----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(showMenu)
                        .toString()
                )
        );
    }
    /**
     * Test showAll action.
     */
    @Test
    public void whenUserWantsToShowAllItemsThenShowAll() {
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(showMenu)
                        .append("------------ Все хранимые заявки --------------")
                        .append(System.lineSeparator())
                        .append("ID ").append(tracker.findAll()[0].getId())
                        .append(" Имя: ").append(tracker.findAll()[0].getName())
                        .append(" Описание: ").append(tracker.findAll()[0].getDescription())
                        .append(System.lineSeparator())
                        .append("ID ").append(tracker.findAll()[1].getId())
                        .append(" Имя: ").append(tracker.findAll()[1].getName())
                        .append(" Описание: ").append(tracker.findAll()[1].getDescription())
                        .append(System.lineSeparator())
                        .append("ID ").append(tracker.findAll()[2].getId())
                        .append(" Имя: ").append(tracker.findAll()[2].getName())
                        .append(" Описание: ").append(tracker.findAll()[2].getDescription())
                        .append(System.lineSeparator())
                        .append("ID ").append(tracker.findAll()[3].getId())
                        .append(" Имя: ").append(tracker.findAll()[3].getName())
                        .append(" Описание: ").append(tracker.findAll()[3].getDescription())
                        .append(System.lineSeparator())
                        .append("ID ").append(tracker.findAll()[4].getId())
                        .append(" Имя: ").append(tracker.findAll()[4].getName())
                        .append(" Описание: ").append(tracker.findAll()[4].getDescription())
                        .append(System.lineSeparator())
                        .append("-----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(showMenu)
                        .toString()
                )
        );
    }

    /**
     * Test edit action.
     */
    @Test
    public void whenReplaceTaskThenTrackerHasUpdatedTask() {
        String oldTask = ("ID " + tracker.findAll()[3].getId()
                + " Имя: " + tracker.findAll()[3].getName()
                + " Описание: " + tracker.findAll()[3].getDescription());
        Input input = new StubInput(new String[]{"2", tracker.findAll()[3].getId(), "replaced name", "replaced desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(showMenu)
                        .append("------------ Редактирование заявки --------------")
                        .append(System.lineSeparator())
                        .append("------------ Данные редактируемой заявки --------------")
                        .append(System.lineSeparator())
                        .append(oldTask)
                        .append(System.lineSeparator())
                        .append("------------ Заявка с новыми данными --------------")
                        .append(System.lineSeparator())
                        .append("ID: ").append(tracker.findAll()[3].getId())
                        .append(" Имя: ").append(tracker.findAll()[3].getName())
                        .append(" Описание: ").append(tracker.findAll()[3].getDescription())
                        .append(System.lineSeparator())
                        .append("-----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(showMenu)
                        .toString()
                )
        );
    }

    /**
     * Test delete action.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNoItemWithTheSame() {
        Item toDelete = tracker.findAll()[0];
        Input input = new StubInput(new String[]{"3", toDelete.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(showMenu)
                        .append("------------ Удаление заявки --------------")
                        .append(System.lineSeparator())
                        .append("------------ Заявка с ID ").append(toDelete.getId()).append(" удалена--------------")
                        .append(System.lineSeparator())
                        .append("-----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(showMenu)
                        .toString()
                )
        );
    }

    /**
     * Test findById action.
     */
    @Test
    public void whenItemIsStoredThenFoundByID() {
        Item searchItem = tracker.findAll()[3];
        Input input = new StubInput(new String[]{
                "4", searchItem.getId(),
                "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(showMenu)
                        .append("------------ Поиск заявок по ID --------------")
                        .append(System.lineSeparator())
                        .append("------------ Найденная заявка --------------")
                        .append(System.lineSeparator())
                        .append("ID ").append(searchItem.getId())
                        .append(" Имя: ").append(searchItem.getName())
                        .append(" Описание: ").append(searchItem.getDescription())
                        .append(System.lineSeparator())
                        .append("-----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(showMenu)
                        .toString()
                )
        );
    }

    /**
     * Test findByName action.
     */
    @Test
    public void whenItemIsStoredThenFoundByName() {
        String key = "third";
        Input input = new StubInput(new String[]{"5", key, "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append(showMenu)
                        .append("------------ Поиск заявок по имени --------------")
                        .append(System.lineSeparator())
                        .append("------------ Найденные заявки --------------")
                        .append(System.lineSeparator())
                        .append("ID ").append(tracker.findByName(key)[0].getId())
                        .append(" Имя: ").append(tracker.findByName(key)[0].getName())
                        .append(" Описание: ").append(tracker.findByName(key)[0].getDescription())
                        .append(System.lineSeparator())
                        .append("-----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(showMenu)
                        .toString()
                )
        );
    }
}