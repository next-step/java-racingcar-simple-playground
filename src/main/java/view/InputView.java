package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getCarNames() {
        System.out.println(
                "경주할 자동차 이름을 입력하세요."
                        + "(이름은 쉼표(,) 기준으로 구분)"
        );

        return parseCarNames(scanner.nextLine());
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}