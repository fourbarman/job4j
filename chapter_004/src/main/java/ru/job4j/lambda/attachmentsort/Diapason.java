package ru.job4j.lambda.attachmentsort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Diapason.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 13.04.2020
 */
public class Diapason {
    /**
     * Returns list of function results.
     *
     * @param start Start of diapason..
     * @param end   End of diapason.
     * @param func  Function to calculate.
     * @return list.
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        while (start < end) {
            result.add(func.apply((double) start));
            start++;
        }
        return result;
    }
}
