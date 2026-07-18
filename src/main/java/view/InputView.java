package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String value = scanner.nextLine();
        String[] splitNames = value.split(",");
        for (String name : splitNames) {
            carNames.add(name.trim());
        }

        return carNames;
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
