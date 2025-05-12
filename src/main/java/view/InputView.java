package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String readCarNames() {
        return scanner.nextLine();
    }

    public int readGameRounds() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("정수가 아닌 입력입니다.");
        }
    }
}
