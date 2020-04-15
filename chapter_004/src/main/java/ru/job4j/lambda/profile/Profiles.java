package ru.job4j.lambda.profile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Profiles.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 15.04.2020
 */
public class Profiles {
    /**
     * Returns list of addresses.
     *
     * @param profiles List of profiles.
     * @return list.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
