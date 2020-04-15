package ru.job4j.lambda.profile;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.lambda.profile.Profile.collect;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 14.04.2020
 */
public class ProfileTest {
    /**
     * Test when take 2 address.
     */
    @Test
    public void whenTakeAddressFrom2ProfilesThan2Addresses() {
        Profile profile = new Profile();
        profile.setAddress(new Address("City1", "Street1", 1, 1));
        Profile profile2 = new Profile();
        profile2.setAddress(new Address("City2", "Street2", 2, 2));
        List<Profile> list = List.of(profile, profile2);
        assertThat(collect(list).size(), is(2));
    }
}
