package view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static List<String> getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();

        validateCarNameInput(value);

        List<String> carNames = Arrays.stream(value.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        validateCarNames(carNames);

        return List.copyOf(carNames);
    }

    private static void validateCarNameInput(String value) {
        if (value.isEmpty()) {
            throw new NoSuchElementException("경주할 자동차 이름을 반드시 입력해주세요.");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 올바르게 입력해주세요.");
        }

        if (carNames.stream().anyMatch(name -> name.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
        }
    }

    public static int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        int attemptCount = validateTryCountInput(scanner);
        validateTryCount(attemptCount);

        return attemptCount;
    }

    private static int validateTryCountInput(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        return scanner.nextInt();
    }

    private static void validateTryCount(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도할 회수는 1 이상의 정수여야 합니다.");
        }
    }

}
