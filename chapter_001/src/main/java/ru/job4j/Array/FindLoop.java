package ru.job4j.array;
/**
 * Array square.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 30.08.2018.
 */
public class FindLoop {
    /**
     * Calculate array of square values.
     * @param data Array to search in.
     * @param el Searching element.
     * @return Array of square values.
     */
    public int findLoop(int[] data, int el) {
        int rst = -1; //if not found element in array return -1
        for (int i = 0; i != data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
