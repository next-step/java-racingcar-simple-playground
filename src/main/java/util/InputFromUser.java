package util;

import java.util.List;
import java.util.Scanner;

public class InputFromUser {

    static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        List<String> carNames = null;
        boolean retry = true;
        while (retry) {
            carNames = SplitCarNames.splitCarNames(scanner.nextLine());
            retry = splitAndCheckCarNames(carNames);
        }
        return carNames;
    }

    public static int inputExecutionsCount() {
        String executionsCount = null;
        boolean retry = true;
        while (retry) {
            executionsCount = scanner.nextLine();
            retry = checkIsValidExecutionsCount(executionsCount);
        }
        return Integer.parseInt(executionsCount);
    }

    private static boolean splitAndCheckCarNames(List<String> carNames) {
        try {
            InputFromUserValidator.checkCarNames(carNames);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private static boolean checkIsValidExecutionsCount(String executionsCount) {
        try {
            InputFromUserValidator.checkExecutionsCount(executionsCount);
            return false;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}