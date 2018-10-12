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
     * @return Is X winner.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1);
    }
    /**
     * Checks the winner is O.
     * @return Is O winner.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1 , 0, -1, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1);
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
    /**
     * Checks if elements in one row are equal: hasMarkX or hasMarkO.
     * @param predicate Predicate.
     * @param startX Start X position.
     * @param startY Start Y position.
     * @param deltaX X offset.
     * @param deltaY Y offset.
     * @return If array contains equal object property values.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
