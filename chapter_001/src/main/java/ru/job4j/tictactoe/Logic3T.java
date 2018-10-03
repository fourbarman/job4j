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
        for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][0].hasMarkX() & this.table[i][1].hasMarkX() & this.table[i][2].hasMarkX()) {
                    result = true;
                    break;
            }
        }
        //checking diagonals
        for (int i = 1; i <= this.table.length - 1; i++) {
            if ((this.table[i - 1][i - 1].hasMarkX() == this.table[i][i].hasMarkX())
                    || (this.table[i - 1][this.table.length - i].hasMarkX() == this.table[i][this.table.length - i - 1].hasMarkX())) {
                result = true;
                break;
            }
        }
        //checking verticals
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[0][i].hasMarkX() && this.table[1][i].hasMarkX() && this.table[2][i].hasMarkX()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        //checking horisontals
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][0].hasMarkO() && this.table[i][1].hasMarkO() && this.table[i][2].hasMarkO()) {
                result = true;
                break;
            }
        }
        //checking diagonals
        for (int i = 1; i <= this.table.length - 1; i++) {
            if ((this.table[i - 1][i - 1].hasMarkO() == this.table[i][i].hasMarkO())
                    || (this.table[i - 1][this.table.length - i].hasMarkO() != this.table[i][this.table.length - i - 1].hasMarkO())) {
                result = true;
                break;
            }
        }
        //checking verticals
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[0][i].hasMarkO() && this.table[1][i].hasMarkO() && this.table[2][i].hasMarkO()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX() || !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
