package ru.job4j.collection.notifyaccount;

import java.util.Objects;
/**
 * Account.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 17.03.2020.
 */
public class Account {
    private String passport;
    private String username;
    private String deposit;

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }
    /**
     * Compares objects by passport.
     *
     * @param o Object to compare with.
     * @return if o equals current object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }
    /**
     * Calculating hash code.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
    /**
     * Returns object as a string.
     *
     * @return object as a string.
     */
    @Override
    public String toString() {
        return "Account{"
                + "passport='" + passport + '\''
                + ", username='" + username + '\''
                + ", deposit='" + deposit + '\''
                + '}';
    }
}
