package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 31.08.2018
 */
public class CheckTest {
    /**
     * Test mono.
     */
    @Test
    public void whenArrayIsMonoTrueByTrue() {
        boolean[] data = new boolean[] {true, true, true};
        Check check = new Check();
        boolean result = check.mono(data);
        assertThat(result, is(true));
    }
    /**
     * Test mono.
     */
    @Test
    public void whenArrayNotMono() {
        boolean[] data = new boolean[] {true, false, true, false};
        Check check = new Check();
        boolean result = check.mono(data);
        assertThat(result, is(false));
    }
}
