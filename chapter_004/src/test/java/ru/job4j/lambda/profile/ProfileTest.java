package ru.job4j.lambda.profile;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.lambda.profile.Profiles.collect;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 14.04.2020
 */
public class ProfileTest {
    /**
     * Test when 2 addresses from 3 are equal.
     */
    @Test
    public void whenTwoAddressesFromThreeAreEqualThanReturnTwoDistinct() {
        Profile profile = new Profile();
        profile.setAddress(new Address("City1", "Street1", 1, 1));
        Profile profile1 = new Profile();
        profile1.setAddress(new Address("City1", "Street1", 1, 1));
        Profile profile2 = new Profile();
        profile2.setAddress(new Address("City2", "Street2", 2, 2));
        List<Profile> list = List.of(profile, profile1, profile2);
        assertThat(collect(list).size(), is(2));
    }
}
