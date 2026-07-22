package view;

import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String[] inputNames() {
        // 이름을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] input;

        // 입력값이 유효한지 검증
        // 내부 메소드로 분리함
        do {
            input = initNames();
        } while (input == null);

        return input;

    }

    private String[] initNames() {
        try {
            String input = scanner.nextLine();
            return parseNamesInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String[] parseNamesInput(String input) {
        return namesHasSpaceValidation(input);
    }

    private String[] namesHasSpaceValidation(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력값에는 공백이 포함될 수 없습니다.");
        }
        return input.split(",");
    }

    public int inputTurnCount() {
        // 턴 수를 입력받음
        System.out.println("시도할 회수는 몇회인가요?");
        int turnCount;

        // 턴 수 검증
        // 내부 메소드로 분리함
        do {
            turnCount = initTurnCount();
        } while (turnCount < 0);

        return turnCount;
    }

    private int initTurnCount() {
        int input;
        try {
            input = scanner.nextInt();
            turnCountInputValidation(input);
            return input;
        } catch (InputMismatchException e) {
            System.out.println("입력값은 음이 아닌 정수만 가능합니다.");
            scanner.next();
            return -1;
        } catch (IllegalArgumentException e) {
            System.out.println("입력값은 음이 아닌 정수만 가능합니다.");
            return -1;
        }
    }

    private void turnCountInputValidation(int input) {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
    }
}
