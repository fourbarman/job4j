package ru.job4j.lambda.profile;

/**
 * Profile.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 15.04.2020
 */
public class Profile {
    private Address address;

    /**
     * Set address.
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Get address.
     */
    public Address getAddress() {
        return this.address;
    }
}