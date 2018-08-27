package ru.job4j.loop;
/**
 * Board.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 27.08.2018.
 */
public class Board {
    /**
     * Paint board.
     * @param width Board width.
     * @param height Board Height.
     * @return Board painting.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //if (i+j) - even, then add X
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
