package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * @author fourbarman (maks.java@yandex.ru).
 * @version $Id$.
 * @since 17.10.2018.
 */
public class Logic {
    /**
     * Preference size.
     * Preference figures.
     * Preference index.
     */
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    /**
     * Constructor - builds new object with parameter.
     *
     * @param size IS size of figures.
     */
    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    /**
     * Adds figures.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * @return Is change position.
     */
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    /**
     * Checks if cell is free.
     * @return if cell is free.
     */
    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    /**
     * Cleans array figures.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Searches index cell.
     * @return index.
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Checks if win.
     * @return if win.
     */
    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            int row = 1;
            int col = 1;
            for (int j = 0; j < table.length; j++) {
                row *= table[i][j];
                col *= table[j][i];
            }
            if (row == 1 || col == 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Coverts figure to 1 or 0.
     * @return table with 0 or 1.
     */
    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
