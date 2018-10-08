package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Class for represent cells with preferences <b>markX</b> and <b>markO</b>.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.10.2018.
 */
public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    /**
     * Constructor for creating new object.
     * @see Figure3T#Figure3T(boolean).
     */
    public Figure3T() {
    }

    /**
     * Constructor for creating new object with parameter.
     * @param markX Cell has mark X.
     * @see Figure3T#Figure3T().
     */
    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Sets parameter mark X.
     * @param markX Cell has mark X
     */
    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Returns if object has mark X.
     * @return Cell has mark X.
     */
    public boolean hasMarkX() {
        return this.markX;
    }

    /**
     * Returns if object has mark O.
     * @return Cell has mark O.
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}
