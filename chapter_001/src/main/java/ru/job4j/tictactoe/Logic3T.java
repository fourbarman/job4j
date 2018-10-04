package ru.job4j.tictactoe;


import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        //checking horisontals
        for (int i = 0; i < table.length; i++) {
                if (table[i][0].hasMarkX() && table[i][1].hasMarkX() && table[i][2].hasMarkX()) {
                    result = true;
                    break;
            }
        }
        //checking diagonals
        if ((table[0][0].hasMarkX() && table[1][1].hasMarkX() && table[2][2].hasMarkX())
                || (table[0][2].hasMarkX() && table[1][1].hasMarkX() && table[2][0].hasMarkX())) {
            result = true;
            }
        //checking verticals
        for (int i = 0; i < table.length; i++) {
            if (table[0][i].hasMarkX() && table[1][i].hasMarkX() && table[2][i].hasMarkX()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        //checking horisontals
        for (int i = 0; i < table.length; i++) {
            if (table[i][0].hasMarkO() && table[i][1].hasMarkO() && table[i][2].hasMarkO()) {
                result = true;
                break;
            }
        }
        //checking diagonals
        if ((table[0][0].hasMarkO() && table[1][1].hasMarkO() && table[2][2].hasMarkO())
                || (table[0][2].hasMarkO() && table[1][1].hasMarkO() && table[2][0].hasMarkO())) {
            result = true;
        }
        //checking verticals
        for (int i = 0; i < table.length; i++) {
            if (table[0][i].hasMarkO() && table[1][i].hasMarkO() && table[2][i].hasMarkO()) {
                result = true;
                break;
            }
        }
        return result;
    }

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
