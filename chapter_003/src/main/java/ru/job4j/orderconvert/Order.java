package ru.job4j.orderconvert;

import java.util.Objects;

/**
 * Order.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 19.03.2020.
 */
public class Order {
    private String number;
    private String name;

    /**
     * Constructor.
     */
    public Order(String number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * Returns order's number.
     *
     * @return number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * toString.
     *
     * @return result.
     */
    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Equals.
     *
     * @param o Object.
     * @return result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(number, order.number) &&
                Objects.equals(name, order.name);
    }

    /**
     * HashCode.
     *
     * @return result.
     */
    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
