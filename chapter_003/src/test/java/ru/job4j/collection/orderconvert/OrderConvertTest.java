package ru.job4j.collection.orderconvert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 19.03.2020
 */
public class OrderConvertTest {
    /**
     * Test when single order.
     */
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }
    /**
     * Test when single order.
     */
    @Test
    public void whenCoupleOrders() {
        List<Order> orders = Arrays.asList(
                new Order("1", "name1"),
                new Order("2", "name2"),
                new Order("3", "name3"),
                new Order("4", "name4"),
                new Order("5", "name5")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3"), is(new Order("3", "name3")));
    }
    /**
     * Test when duplicate values (names).
     */
    @Test
    public void whenDuplicateValueOrdersThanUpdateValue() {
        List<Order> orders = Arrays.asList(
                new Order("1", "name1"),
                new Order("2", "name2"),
                new Order("2", "name3"),
                new Order("2", "name4"),
                new Order("2", "name5")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("2"), is(new Order("2", "name5")));
    }
}
