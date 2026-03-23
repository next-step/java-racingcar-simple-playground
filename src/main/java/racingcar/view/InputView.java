package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        return input.split(",");
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        int tryCount = scanner.nextInt();
        validateTryCount(tryCount);

        return tryCount;
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }
}
