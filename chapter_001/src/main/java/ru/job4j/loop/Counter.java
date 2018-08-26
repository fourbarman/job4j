package ru.job4j.loop;

/**
 * Counter.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 25.08.2018.
 */
public class Counter {
    /**
     * Count even numbers summ from Start to Finish.
     * @param start Start number.
     * @param finish Finish number.
     * @return return amount.
     */
    public int add(int start, int finish) {
        if (Math.abs(start) != 0) {
            start += 1;
        }
        int summ = 0;
        for (int i = start; i <= finish; i += 2) {
            summ = summ + i;
        }
        return summ;
    }
}
