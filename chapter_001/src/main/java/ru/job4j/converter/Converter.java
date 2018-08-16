package ru.job4j.converter;

/**
 * Корвертор валюты.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.08.2018.
 */
public class Converter {
    private double result;
    private int dollarPrice = 60;
    private int euroPrice = 70;
     /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        result = value / euroPrice;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары.
     */
    public double rubleToDollar(int value) {
        result = value / dollarPrice;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value Доллары.
     * @return Рубли.
     */
    public double dollarToRuble(int value) {
        result = value * dollarPrice;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return Доллары.
     */
    public double euroToRuble(int value) {
        result = value * euroPrice;
        return this.result;
    }
}