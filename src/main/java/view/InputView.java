package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String readCarNames() {
        return scanner.nextLine();
    }

    public int readGameRounds() {
        return (int)scanner.nextInt();
    }
}
