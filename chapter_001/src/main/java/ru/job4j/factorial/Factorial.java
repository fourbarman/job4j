package ru.job4j.factorial;

/**
 * Max value.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.08.2018.
 */

public class Factorial {
    /**
     * Count factorial of a number.
     * @param n Factorial value.
     * @return Factorial.
     */
    public int calc(int n) {
        int result = -1; // if n is above 0 then count factorial, else return -1
        if (n >= 0) {
            result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }
}
