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

    /**
     * Get city.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Equals.
     *
     * @param obj Object.
     * @return If equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Address ad = (Address) obj;
        return (
                ad.apartment == this.apartment
                        && ad.home == this.home
                        && ad.street.equals(this.street)
                        && ad.city.equals(this.city)
        );
    }

    /**
     * Returns hashCode from city field.
     *
     * @return int hashcode
     */
    @Override
    public int hashCode() {
        return this.apartment;
    }
}