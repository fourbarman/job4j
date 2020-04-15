package ru.job4j.lambda.profile;

import java.util.List;
import java.util.stream.Collectors;

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
     * Returns list of addresses.
     *
     * @param profiles List of profiles.
     * @return list.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
    }
}