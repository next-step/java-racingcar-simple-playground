package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        List<String> carList = parseCarNames(input);

        return carList;
    }

    public static List<String> parseCarNames(String input) {
        throwIfCarsListIsNull(input);

        List<String> carList = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        return carList;
    }

    private static void throwIfCarsListIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("자동차 리스트가 null일 수 없습니다.");
        }
    }

    public static int getRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}