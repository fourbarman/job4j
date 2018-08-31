package ru.job4j.array;
/**
 * Array turn.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 31.08.2018.
 */
public class Turn {
    /**
     * Turn array.
     * @param array Array to turn.
     * @return Turned array .
     */
    public int[] turn(int[] array) {
        int temp;
        for (int i = 0; i != (array.length / 2); i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
