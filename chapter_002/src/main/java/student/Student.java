package student;
/**
 * Student.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.08.2019.
 */
public class Student {
    /**
     * Prints a string.
     *
     */
    public void music(){
        System.out.println("Tra tra tra");
    }
    /**
     * Prints a string.
     *
     */
    public void song(){
        System.out.println("I believe I can fly");
    }
    /**
     * Main.
     *
     * @param args String arguments.
     */
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
