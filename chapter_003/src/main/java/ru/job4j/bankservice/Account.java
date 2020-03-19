package ru.job4j.bankservice;

import java.util.Objects;

/**
 * Account.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 19.03.2020.
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Constructor.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Returns requisite.
     *
     * @return requisite.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Sets requisite.
     *
     * @param requisite String.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Returns balance.
     *
     * @return result.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance Double.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Compares objects.
     *
     * @param o Object to compare with.
     * @return if o equals current object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Calculating hash code.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}