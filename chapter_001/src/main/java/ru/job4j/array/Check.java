package ru.job4j.array;
/**
 * Array true or false.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 31.08.2018.
 */
public class Check {
    /**
     * Check if array true or false.
     * @param data Array to check.
     * @return True or false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i != data.length; i++) {
            if (data[i - 1] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
