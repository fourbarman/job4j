package tracker;

import java.util.Scanner;

//public class ConsoleInput implements Input {
//    public Scanner scanner = new Scanner(System.in);
//    @Override
//    public String ask(String question) {
//        System.out.println(question);
//        return scanner.nextLine();
//    }
//    @Override
//    public int askInt(String question) {
//        return 1;
//    }
//}
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(ask(question));
    }
}
