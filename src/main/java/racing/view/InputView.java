package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarName() {
        String carName = SCANNER.nextLine();
        validateCarNameFormat(carName);
        return carName;
    }

    public static int inputTrialNumberCount() {
        String input = SCANNER.nextLine();
        return parseTrialCount(input);
    }

    private static void validateCarNameFormat(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        String noSpaceInput = input.replace(" ", "");
        if (noSpaceInput.contains(",,")) {
            throw new IllegalArgumentException("[ERROR] 쉼표가 연속으로 입력되었습니다.");
        }
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 입력값의 시작이나 끝에 쉼표가 있습니다.");
        }
    }

    private static int parseTrialCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수 형의 숫자여야 합니다.");
        }
    }
}
