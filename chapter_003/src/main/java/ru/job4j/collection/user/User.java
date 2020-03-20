package ru.job4j.collection.user;

import java.util.Objects;

/**
 * User.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 20.03.2020.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    /**
     * Constructor.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Compares user by name, if equals than compares by age.
     * Returns 0 if objects equal.
     * Returns 1 if this object is greater.
     * Returns -1 if this object is less.
     *
     * @param o User.
     * @return int.
     */
    @Override
    public int compareTo(User o) {
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        } else {
            return ((Integer) this.age).compareTo(o.age);
        }
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
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    /**
     * Calculating hash code.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
