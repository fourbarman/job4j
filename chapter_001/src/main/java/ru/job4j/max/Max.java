package ru.job4j.max;

/**
 * Max value.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.08.2018.
 */
public class Max {
    /**
     * Choose maximum value.
     * @param first First value.
     * @param second Second value.
     * @return Max value.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Choose maximum value.
     * @param first First value.
     * @param second Second value.
     * @param third Third value.
     * @return Max value.
     */
    public int max(int first, int second, int third) {
        int temp = max(first, second);
        int result = max(temp, third);
        return result;
    }
}
