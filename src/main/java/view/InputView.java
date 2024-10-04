package view;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public static int readAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
