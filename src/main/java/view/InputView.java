package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<String> readCarNames(Scanner scanner) {
        System.out.println(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        );
        return readCarNames(scanner.nextLine());
    }

    public static List<String> readCarNames(String input) {
        return Arrays.asList(input.split(",", -1));
    }

    public static int readValidRounds(Scanner scanner) {
        Integer rounds = null;
        while (rounds == null) {
            rounds = tryReadRounds(scanner);
        }
        return rounds;
    }

    private static Integer tryReadRounds(Scanner scanner) {
        try {
            return readRounds(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("0 이상의 정수를 입력해주세요.");
            return null;
        }
    }

    public static int readRounds(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return readRounds(scanner.nextLine());
    }

    public static int readRounds(String input) {
        int rounds = Integer.parseInt(input);
        if (rounds < 0) {
            throw new IllegalArgumentException("횟수는 음수일 수 없습니다.");
        }
        return rounds;
    }
}
