package ru.job4j.passportoffice;

/**
 * PassportOffice.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 18.03.2020.
 */

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    /**
     * Adds citizen objects to HashMap.
     *
     * @param citizen Object.
     * @return result.
     */
    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!this.citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Returns object.
     *
     * @param passport Key.
     * @return result.
     */
    public Citizen get(String passport) {
        return this.citizens.get(passport);
    }
}
