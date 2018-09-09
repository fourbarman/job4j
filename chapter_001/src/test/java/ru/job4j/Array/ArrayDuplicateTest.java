package ru.job4j.array;

//import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 03.08.2018
 */
public class ArrayDuplicateTest {
    /**
     * Test remove.
     */
    @Test
    public void whenArrayHasDuplicatesThenReturnArrayWithoutDuplicates() {
        String[] in = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] out = new String[] {"Привет", "Мир", "Супер"};
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] result = ad.remove(in);
        assertThat(result, arrayContainingInAnyOrder(out));
    }
    /**
     * Test remove when all values equal.
     */
    @Test
    public void whenArrayHasAllDuplicates() {
        String[] in = new String[] {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] out = new String[] {"Привет"};
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] result = ad.remove(in);
        assertThat(result, arrayContainingInAnyOrder(out));
    }
}
