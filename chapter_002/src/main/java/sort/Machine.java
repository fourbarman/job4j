package sort;

import java.util.Arrays;
/**
 * Machine.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.02.2020.
 */
public class Machine {
    private static final int[] COINS = {10, 5, 2, 1};
    /**
     * Counts change.
     *
     * @param money Overall money.
     * @param price Price.
     * @return Array of coins fo change.
     */
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        money -= price;
        for (int i = 0; i < COINS.length; i++) {
            while (money >= COINS[i]) {
                money -= COINS[i];
                rsl[size] = COINS[i];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
