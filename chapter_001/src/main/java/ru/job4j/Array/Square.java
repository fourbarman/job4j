package ru.job4j.array;
/**
 * Array square.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 30.08.2018.
 */
public class Square {
    /**
     * Calculate array of square values.
     * @param bound Array length.
     * @return Array of square values.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != rst.length; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
