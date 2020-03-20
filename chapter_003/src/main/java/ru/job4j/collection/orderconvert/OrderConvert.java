package ru.job4j.collection.orderconvert;

import java.util.HashMap;
import java.util.List;

/**
 * OrderConvert.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 19.03.2020.
 */
public class OrderConvert {
    /**
     * Converts List to HashMap and returns it.
     *
     * @param orders List of Order objects.
     * @return map.
     */
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}
