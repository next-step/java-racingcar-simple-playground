package view;

import validator.CarNamesStringValidator;
import validator.RoundCountValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String rawCarNames = scanner.nextLine();
        List<String> carNames = Arrays.asList(rawCarNames.split(","));

        CarNamesStringValidator.validate(carNames);
        return carNames;
    }

    public static int inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        int roundCount = scanner.nextInt();
        RoundCountValidator.validate(roundCount);

        return roundCount;
    }
}
