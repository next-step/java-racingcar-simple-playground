package view;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return parseCarNames(input);
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private static List<String> parseCarNames(String input) {
        String[] names = splitCarNames(input);
        return createValidatedCarNames(names);
    }

    private static String[] splitCarNames(String input) {
        return input.split(CAR_NAME_DELIMITER);
    }

    private static List<String> createValidatedCarNames(String[] names) {
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();
            validateCarName(trimmedName);
            carNames.add(trimmedName);
        }

        return carNames;
    }

    private static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
