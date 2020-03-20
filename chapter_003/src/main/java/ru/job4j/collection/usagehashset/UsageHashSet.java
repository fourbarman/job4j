package ru.job4j.collection.usagehashset;

import java.util.HashSet;

/**
 * UsageHashSet.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 16.03.2020.
 */
public class UsageHashSet {
    /**
     * Main method.
     */
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String name : autos) {
            System.out.println(name);
        }
    }
}
