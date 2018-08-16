package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author fourbarman (maks.java@yandex.ru)
 * @version 1
 * @since 16.08.2018
 */
public class Calculator {
    private double result;
    /**
     * Method add.
     * @param first First number.
     * @param second Second number.
     * @return Addition Second number to First number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method substract.
     * @param first First number.
     * @param second Second number.
     * @return Substraction Second number from First number.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method multiple.
     * @param first First number.
     * @param second Second number.
     * @return Multiplication Second number with First number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method div.
     * @param first First number.
     * @param second Second number.
     * @return Division First number on Second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method getResult.
     * @return Return result.
     */
    public double getResult() {
        return this.result;
    }
}
