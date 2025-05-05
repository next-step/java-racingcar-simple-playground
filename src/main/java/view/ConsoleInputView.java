package view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String readCarName() {
        return scanner.nextLine();
    }

    @Override
    public String readRound() {
        return scanner.nextLine();
    }
}