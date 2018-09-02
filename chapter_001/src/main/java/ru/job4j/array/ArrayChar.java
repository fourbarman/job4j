package ru.job4j.array;
/**
 * String begins with.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.09.2018.
 */
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Check if the string begins with prefix.
     * @param prefix Prefix to start with.
     * @return If the line starts with prefix.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
