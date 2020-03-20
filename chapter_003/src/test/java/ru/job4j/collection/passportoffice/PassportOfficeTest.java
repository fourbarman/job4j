package ru.job4j.collection.passportoffice;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 18.03.2020
 */
public class PassportOfficeTest {
    /**
     * Test add.
     */
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    /**
     * Test add duplicate keys.
     */
    @Test
    public void addEqualKeys() {
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("2f44a", "Petr Arsentev"));
        assertThat(office.add(new Citizen("2f44a", "Petr Arsentev")), is(false));
    }

    /**
     * Test get.
     */
    @Test
    public void get() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a2", "Petr Arsentev 2");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen2);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
}
