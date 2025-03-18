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
                return validateCarNames(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> validateCarNames(String input) {
        List<String> carNames = parseCarNames(input);

        if (carNames.isEmpty()) {
            throw new InvalidInputException("올바른 자동차 이름을 입력하세요.");
        }

        return carNames;
    }

    private List<String> parseCarNames(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            addValidatedCarName(carNames, name.trim());
        }

        return carNames;
    }

    private void addValidatedCarName(List<String> carNames, String name) {
        validateCarName(name);
        carNames.add(name);
    }

    public void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new InvalidInputException("이름이 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException("이름은 5글자 이내여야 합니다");
        }
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
