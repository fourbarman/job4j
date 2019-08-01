package cat;
/**
 * Cat.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 01.08.2019.
 */
public class Cat {
    private String food;
    private String name;
    /**
     * Gives nickname to a cat.
     *
     * @param nick nickname.
     */
    public void giveNick(String nick){
        this.name = nick;
    }
    /**
     * Shows cat's nickname and food.
     *
     */
    public void show() {
        System.out.println(this.name + " ate " + this.food);
    }
    /**
     * Cat's meal.
     *
     * @param meat Food.
     */
    public void eat(String meat) {
        this.food = meat;
    }
    /**
     * Main.
     *
     * @param args String arguments.
     */
    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
