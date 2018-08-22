package ru.job4j.conditionbot;

import org.junit.Test;
import ru.job4j.conditionbot.DummyBot;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 22.08.2018
 */
public class DummyBotTest {
    /**
     * Test whenQuestionHiBot.
     */
    @Test
    public void whenQuestionHiBot() {
        DummyBot dBot = new DummyBot();
        assertThat(dBot.answer("Привет, Бот."), is("Привет, умник."));
    }

    /**
     * Test whenQuestionBuyBot.
     */
    @Test
    public void whenQuestionBuyBot() {
        DummyBot dBot = new DummyBot();
        assertThat(dBot.answer("Пока."), is("До скорой встречи."));
    }

    /**
     * Test whenQuestionSomethingElse.
     */
    @Test
    public void whenQuestionSomethingElse() {
        DummyBot dBot = new DummyBot();
        assertThat(dBot.answer("Сколько будет 2 + 2?"), is("Это ставит меня в тупик. Спросите другой вопрос."));
    }
}
