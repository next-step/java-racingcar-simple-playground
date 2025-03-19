package CarGame2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private static final int MAX_NAME_LENGTH = 5;

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표를 기준으로 구분)");

        while (true) {
            try {
                return parseCarNames(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> parseCarNames(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            carNames.add(name.trim());
        }

        return carNames;
    }

    public int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");

        while (true) {
            try {
                return validateRounds(scanner.nextLine().trim());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateRounds(String input) {
        try {
            int rounds = Integer.parseInt(input);
            validateNumber(rounds);
            return rounds;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("유효한 숫자를 입력해주세요.");
        }
    }

    private void validateNumber(int rounds) {
        if (rounds <= 0) {
            throw new InvalidInputException("1 이상의 숫자를 입력해주세요.");
        }
    }
}
