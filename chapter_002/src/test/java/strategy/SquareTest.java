package strategy;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 18.02.2019
 */
public class SquareTest {
    /**
     * Test draw.
     */
    @Test
    public void whenDrawsSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder().append("****")
                                                        .append(System.lineSeparator())
                                                        .append("*  *")
                                                        .append(System.lineSeparator())
                                                        .append("*  *")
                                                        .append(System.lineSeparator())
                                                        .append("****")
                                                        .toString()
                )
        );
    }
}
