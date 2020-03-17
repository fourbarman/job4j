package ru.job4j.uniquetext;

import java.util.HashSet;

/**
 * UniqueTextTest.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 17.03.2020.
 */
public class UniqueText {
    /**
     * Returns true if second string is not unique.
     *
     * @param originText    Original string.
     * @param duplicateText String to compare.
     * @return result.
     */
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String s : origin) {
            check.add(s);
        }
        for (String str : text) {
            if (!check.contains(str)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
