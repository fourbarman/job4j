package ru.job4j.lambda.attachmentsort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * RefMethod.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.04.2020.
 */
public class RefMethod {
    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    /**
     * Cuts string.
     *
     * @param value
     */
    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}
