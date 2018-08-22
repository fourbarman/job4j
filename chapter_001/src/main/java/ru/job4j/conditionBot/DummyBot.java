package ru.job4j.conditionbot;

/**
 * DummyBot.
 *
 * @author fourbarman (maks.java@yandex.ru)
 * @version 1
 * @since 22.08.2018
 */
public class DummyBot {
    /**
     * Asking questions.
     * @param question Client question.
     * @return Answer.
     */
    public String answer(String question) {
        String result = "Это ставит меня в тупик. Спросите другой вопрос.";
        if (question.equals("Привет, Бот.")) {
            result = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            result = "До скорой встречи.";
        }
        return result;
    }
}
