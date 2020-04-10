package ru.job4j.lambda.attachmentsort;

import java.util.Comparator;

/**
 * StringCompare.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 10.04.2020.
 */
public class StringCompare {
    Comparator<String> cmpText = (left, right) -> left.compareTo(right);
    Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();
    Comparator<String> cmpTextOut = (left, right) -> {
        System.out.println(left.compareTo(right));
        return left.compareTo(right);
    };
    Comparator<String> cmpDescSizeOut = (left, right) -> {
        System.out.println(right.length() - left.length());
        return right.length() - left.length();
    };
}
