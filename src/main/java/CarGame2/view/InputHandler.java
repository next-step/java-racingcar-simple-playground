package CarGame2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표를 기준으로 구분)");
        return parseCarNames(scanner.nextLine());
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
        return validateRounds(scanner.nextLine().trim());
    }

    public int validateRounds(String input) {
        int rounds = Integer.parseInt(input);
        return rounds;
    }

}
