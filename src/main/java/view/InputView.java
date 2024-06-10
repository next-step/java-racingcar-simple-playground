package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";

    public static String[]  getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        final Scanner scanner = new Scanner(System.in);
        final String nameInput = scanner.nextLine();

        final String[] names = nameInput.split(NAME_DELIMITER);
        validateNames(names);

        return names;
    }

    private static void validateNames(String[] names) {
        if (Arrays.stream(names).anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
