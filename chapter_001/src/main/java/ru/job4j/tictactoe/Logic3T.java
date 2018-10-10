package ru.job4j.tictactoe;


import java.util.function.Predicate;

/**
 * Class builds table with Figure3T objects.
 * Responsible for game logic.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1b.
 * @since 08.10.2018.
 */
public class Logic3T {

    /**
     * Preference table.
     */
    private final Figure3T[][] table;

    /**
     * Constructor - builds new table with parameter.
     *
     * @param table 2D array for building game table.
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Checks the winner is X.
     * First loop checks rows and columns.
     * Second loop checks diagonals.
     * @return Is X winner.
     */
    public boolean isWinnerX() {
        boolean col, row, toright, toleft;
        for (int i = 0; i < table.length; i++) {
            col = true;
            row = true;
            for (int j = 0; j < table.length; j++) {
                col &= table[i][j].hasMarkX();
                row &= table[j][i].hasMarkX();
            }
            if (col || row) return true;
        }
        toright = true;
        toleft = true;
        for (int i = 0; i < table.length; i++) {
            toright &= table[i][i].hasMarkX();
            toleft &= table[table.length - i - 1][i].hasMarkX();
        }
        if (toright || toleft) return true;
        return false;
    }

    /**
     * Checks the winner is O.
     * First loop checks rows and columns.
     * Second loop checks diagonals.
     * @return Is O winner.
     */
    public boolean isWinnerO() {
        boolean col, row, toright, toleft;
        for (int i = 0; i < table.length; i++) {
            col = true;
            row = true;
            for (int j = 0; j < table.length; j++) {
                col &= table[i][j].hasMarkO();
                row &= table[j][i].hasMarkO();
            }
            if (col || row) return true;
        }
        toright = true;
        toleft = true;
        for (int i = 0; i < table.length; i++) {
            toright &= table[i][i].hasMarkO();
            toleft &= table[table.length - i - 1][i].hasMarkO();
        }
        if (toright || toleft) return true;
        return false;
    }

    /**
     * Checks if the table has free cell to keep gaming.
     * @return If the table has free cell.
     */
    public boolean hasGap() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}
