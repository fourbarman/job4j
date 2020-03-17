package ru.job4j.notifyaccount;

import java.util.HashSet;
import java.util.List;
/**
 * NotifyAccount.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 17.03.2020.
 */
public class NotifyAccount {
    /**
     * Adds objects from List to HashSet.
     *
     * @param accounts List of Account objects.
     * @return HashSet.
     */
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account acc : accounts) {
            rsl.add(acc);
        }
        return rsl;
    }
}
