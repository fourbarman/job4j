package ru.job4j.usagemap;

import java.util.HashMap;
import java.util.Map;

/**
 * UsageMap.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.03.2020.
 */
public class UsageMap {
    /**
     * Main method.
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("test" + i + "@mail.ru", i + " Name");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
