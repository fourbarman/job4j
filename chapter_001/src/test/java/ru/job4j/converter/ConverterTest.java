package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 16.08.2018
 */
public class ConverterTest {

    /**
     * Test rubleToDollar.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(60);
        assertThat(result, is(1.0));
    }

    /**
     * Test rubleToEuro.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(70);
        assertThat(result, is(1.0));
    }

    /**
     * Test add.
     */
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(1);
        assertThat(result, is(70.0));
    }

    /**
     * Test add.
     */
    @Test
    public void when1DollarToRubleThen60() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(1);
        assertThat(result, is(60.0));
    }
}