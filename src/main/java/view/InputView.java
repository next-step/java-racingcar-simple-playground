package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int MIN_TRY_COUNT = 1;
    static Scanner sc = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = sc.nextLine();
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int tryCount = sc.nextInt();
            validatePositive(tryCount); // 0이나 음수 검증
            return tryCount;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validatePositive(int count) {
        if (count < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

    }
}
