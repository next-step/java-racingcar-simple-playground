package view;

import java.util.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::strip)
                .toList();
    }

    public static int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
