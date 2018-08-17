package ru.job4j.fit;

/**
 * Fit - human optimal weight.
 *
 * @author fourbarman (maks.java@yandex.ru)
 * @version 1
 * @since 17.08.2018
 */
public class Fit {

    /**
     * Man's ideal weight.
     * @param height Height.
     * @return ideal weight.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Man's ideal weight.
     * @param height Height.
     * @return ideal weight.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
