package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("[Input Error] 값을 입력해야 합니다.");
        }
    }

    @Override
    public int readNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("[Input Error] 숫자만 입력해야 합니다.");
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}
