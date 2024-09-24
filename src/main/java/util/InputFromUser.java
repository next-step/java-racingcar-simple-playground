package util;

import java.util.List;
import java.util.Scanner;

public class InputFromUser {

    static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        try {
            List<String> carNames = SplitCarNames.splitCarNames(scanner.nextLine());
            InputFromUserValidator.checkCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    public static int inputExecutionsCount() {
        try {
            String executionsCount = scanner.nextLine();
            InputFromUserValidator.checkExecutionsCount(executionsCount);
            return Integer.parseInt(executionsCount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputExecutionsCount();
        }
    }
}
