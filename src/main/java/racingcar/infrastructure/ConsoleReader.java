package racingcar.infrastructure;

import java.util.InputMismatchException;
import java.util.Scanner;
import racingcar.view.Reader;

public class ConsoleReader implements Reader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine();
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
