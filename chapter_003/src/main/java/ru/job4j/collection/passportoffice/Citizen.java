package ru.job4j.collection.passportoffice;

import java.util.Objects;

/**
 * Citizen.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.03.2020.
 */
public class Citizen {
    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Equals.
     *
     * @param o Object.
     * @return result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) o;
        return Objects.equals(passport, citizen.passport);
    }

    /**
     * HashCode.
     *
     * @return result.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
