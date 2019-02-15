package strategy;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    /**
     * Test draw.
     */
    @Test
    public void whenDrawsTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder().append("  *  ")
                                                          .append(" * * ")
                                                          .append("*   *")
                                                          .append("*****")
                                                          .toString()
                )
        );
    }
}