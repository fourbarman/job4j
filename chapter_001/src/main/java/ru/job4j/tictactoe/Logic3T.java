package ru.job4j.tictactoe;


import java.util.function.Predicate;

/**
 * Class builds table with Figure3T objects.
 * Responsible for game logic.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.10.2018.
 */
public class Logic3T {

    /**
     * Preference table.
     */
    private final Figure3T[][] table;

    /**
     * Constructor - builds new table with parameter.
     * @param table 2D array for building game table.
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Checks the winner is X.
     * @return Is X winner.
     */
    public boolean isWinnerX() {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
                if (table[i][0].hasMarkX() && table[i][1].hasMarkX() && table[i][2].hasMarkX()) {
                    result = true;
                    break;
            }
        }
        if ((table[0][0].hasMarkX() && table[1][1].hasMarkX() && table[2][2].hasMarkX())
                || (table[0][2].hasMarkX() && table[1][1].hasMarkX() && table[2][0].hasMarkX())) {
            result = true;
            }
        for (int i = 0; i < table.length; i++) {
            if (table[0][i].hasMarkX() && table[1][i].hasMarkX() && table[2][i].hasMarkX()) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checks the winner is O.
     * @return Is O winner.
     */
    public boolean isWinnerO() {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i][0].hasMarkO() && table[i][1].hasMarkO() && table[i][2].hasMarkO()) {
                result = true;
                break;
            }
        }
        if ((table[0][0].hasMarkO() && table[1][1].hasMarkO() && table[2][2].hasMarkO())
                || (table[0][2].hasMarkO() && table[1][1].hasMarkO() && table[2][0].hasMarkO())) {
            result = true;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[0][i].hasMarkO() && table[1][i].hasMarkO() && table[2][i].hasMarkO()) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checks if the table has free cell to keep gaming.
     * @return If the table has free cell.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkX() || !table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
