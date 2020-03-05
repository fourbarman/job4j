package ru.job4j.collection;

import java.util.ArrayList;

/**
 * UsageArrayList.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 05.03.2020.
 */
public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String s: names) {
            System.out.println(s);
        }
    }
}
