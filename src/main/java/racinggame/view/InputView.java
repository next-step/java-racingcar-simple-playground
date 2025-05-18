package racinggame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String CAR_NAME_INPUT_PROMPT ="경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static List<String> readCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CAR_NAME_INPUT_PROMPT);

        List<String> names = Arrays.stream(scanner.nextLine().split(DELIMITER))
                .map(String::trim)
                .toList();

        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        Set<String> unique = names.stream().collect(Collectors.toSet());
        if (unique.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 모두 고유해야 합니다.");
        }

        return names;
    }

    public static int readMoveCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        int moveCount = scanner.nextInt();
        if (moveCount <= 0) {
            throw new IllegalArgumentException("moveCount는 0보다 큰 값이여야 합니다.");
        }

        return moveCount;
    }
}
