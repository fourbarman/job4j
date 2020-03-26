package ru.job4j.collection.bankservice;

import java.util.Objects;

/**
 * User.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 19.03.2020.
 */
public class User {
    private String passport;
    private String username;

    /**
     * Constructor.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Returns passport.
     *
     * @return passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Sets passport.
     *
     * @param passport String.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Returns username.
     *
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username String.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Compares objects.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
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
}
