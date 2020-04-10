package ru.job4j.lambda.attachmentsort;

import java.util.Arrays;
import java.util.Comparator;
/**
 * LambdaArgs.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 10.04.2020.
 */
public class LambdaArgs {
    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };
//        String[] names = {
//                "Ivan"
//        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
