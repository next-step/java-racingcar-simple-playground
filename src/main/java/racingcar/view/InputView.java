package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        return List.of(value.split(","));
    }

    public static int setTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        System.out.println(); // 출력 형식에 맞추기 위한 줄바꿈
        return number;
    }

    public static void closeScanner() {
        scanner.close();
    }
}