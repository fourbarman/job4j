package jukebox;
/**
 * Jukebox.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.08.2019.
 */
public class Jukebox {
    /**
     * Prints a song.
     *
     * @param position Song number.
     */
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }
    /**
     * Main.
     *
     * @param args String arguments.
     */
    public static void main(String[] args) {
        Jukebox jb = new Jukebox();
        jb.music(1);
        jb.music(2);
        jb.music(3);
    }
}
