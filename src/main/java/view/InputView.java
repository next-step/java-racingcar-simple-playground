package view;

import domain.RacingCar;

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static List<RacingCar> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)로 구분):");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        return createCars(carNames);
    }

    private static List<RacingCar> createCars(String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            verifyCarName(name);
            cars.add(new RacingCar(name, random));
        }
        return cars;
    }

    private static void verifyCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
        }
    }

    public static int getRoundsFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해야 합니다. 다시 입력하세요:");
            scanner.nextLine();
        }

        int rounds = scanner.nextInt();
        scanner.nextLine();

        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        return rounds;
    }
}
