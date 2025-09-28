package view;

import domain.Cars;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Cars inputCarName() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                String[] inputName = scanner.nextLine().split(",");
                for (int i = 0; i < inputName.length; i++) {
                    inputName[i] = inputName[i].trim();
                }
                List<String> names = Arrays.asList(inputName);

                return Cars.createCars(names);

            } catch (IllegalArgumentException input) {
                System.out.println("입력 오류이므로 다시 입력해주세요.");
            }
        }
    }

    public static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            try {
                int round = scanner.nextInt();
                scanner.nextLine();
                return round;
            } catch (InputMismatchException input) {
                System.out.println("회수는 숫자로 입력해 주세요!!");
                scanner.nextLine();
            }
        }
    }
}
