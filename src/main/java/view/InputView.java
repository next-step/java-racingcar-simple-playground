package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        List<String> carList = Arrays.stream(input.split(","))
                .map(String::trim) // 공백 제거
                .collect(Collectors.toList());

        return carList;
    }

    public static int getRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
