package tracker;

import java.util.Scanner;

public class ConsoleInput implements Input{
    public Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
