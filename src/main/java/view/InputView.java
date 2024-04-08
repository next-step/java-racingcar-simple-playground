package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() { // 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();
        return parseCarNames(inputNames);
    }

    private static List<String> parseCarNames(String inputNames) {
        String[] carNames = inputNames.split(","); // 쉼표를 통해 구분

        List<String> cars = new ArrayList<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (isNameValid(trimmedName)) {
                cars.add(trimmedName);
            }
        }
        return cars;
    }

    public static int getTryCount() {
        // 사용자로부터 시도할 회수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private static boolean isNameValid(String name) {
        return name.length() <= 5; // 자동차 이름이 5자 이하인지 확인
    }
}
