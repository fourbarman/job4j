package ru.job4j.collection.bankservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BankService.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 19.03.2020.
 */
public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Adds a User object to HashMap.
     *
     * @param user User.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Adds Account object to HashMap.
     *
     * @param passport String.
     * @param account  Account.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            this.users.get(user).add(account);
        }
    }

    /**
     * Finds User object by passport.
     *
     * @param passport String.
     * @return user.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(accounts -> accounts.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds Account by passport and requisite.
     *
     * @param passport  String.
     * @param requisite String.
     * @return account.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Transfers amount from one account to another.
     * Returns true if success.
     *
     * @param srcPassport   String.
     * @param srcRequisite  String.
     * @param destPassport  String.
     * @param destRequisite String.
     * @param amount        Double.
     * @return result.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
