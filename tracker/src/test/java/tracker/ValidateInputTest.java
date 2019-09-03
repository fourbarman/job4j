package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tracker.start.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    /**
     * Test.
     *
     * @author fourbarman (mailto:maks.java@yandex.ru)
     * @version $Id$
     * @since 27.08.2019
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    public List<UserAction> range;

    @Before

    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
        //tracker = new Tracker();
        range = new ArrayList<>();
        range.add(new AddItem(0, "Add new Item"));
        range.add(new ShowItems(1, "Show all Items"));
        range.add(new EditItem(2, "Edit item"));
//        range.add(new DeleteItem(3, "Delete Item"));
//        range.add(new FindById(4, "Find item by Id"));
//        range.add(new FindByName(5, "Find items by name"));
//        range.add(new Exit(ui, 6, "Exit program"));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("gogo", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }
}

