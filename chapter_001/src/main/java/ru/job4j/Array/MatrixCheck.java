package ru.job4j.array;
/**
 * Mono array.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.09.2018.
 */
public class MatrixCheck {
    /**
     * Check mono array.
     * @param data Input array.
     * @return Mono.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i <= data.length - 1; i++) {
                if ((data[i - 1][i - 1] != data[i][i])
                        || (data[i - 1][data.length - i] != data[i][data.length - i - 1])) {
                    result = false;
                    break;
                }
        }
        return result;
    }
}
