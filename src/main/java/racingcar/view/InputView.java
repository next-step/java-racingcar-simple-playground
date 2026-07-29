package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        List<String> carNames = List.of(value.split(","));
        return carNames;
    }

    public static int setLapCount() {
        int numberInt = 0;
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String numberString = scanner.nextLine();
            numberInt = Integer.parseInt(numberString);
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("올바른 정수 형식으로 입력해주세요");
        }
        return numberInt;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
