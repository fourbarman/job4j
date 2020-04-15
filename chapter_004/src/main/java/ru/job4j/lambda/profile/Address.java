package ru.job4j.lambda.profile;

/**
 * Address.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 15.04.2020
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    /**
     * Constructor.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
}

