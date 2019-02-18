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
public class TriangleTest {
    /**
     * Test draw.
     */
    @Test
    public void whenDrawsTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder().append("  *  ")
                                                          .append(System.lineSeparator())
                                                          .append(" * * ")
                                                          .append(System.lineSeparator())
                                                          .append("*   *")
                                                          .append(System.lineSeparator())
                                                          .append("*****")
                                                          .toString()
                )
        );
    }
}