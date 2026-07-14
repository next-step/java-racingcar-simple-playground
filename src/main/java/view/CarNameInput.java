package view;

import java.util.Scanner;

public class CarNameInput {
    private static final String CAR_NAME_INPUT_MESSAGE = "자동차 이름을 입력하세요.";

    private final Scanner scanner;

    public CarNameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
