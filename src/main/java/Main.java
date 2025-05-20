import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import utils.NumberGenerator;
import utils.RandomNumberGenerator;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = inputCars(scanner);
        int round = inputRound(scanner);

        NumberGenerator generator = new RandomNumberGenerator();
        RacingGame racingGame = new RacingGame(generator, cars);
        racingGame.play(round);

        printWinners(racingGame.getWinners());
    }

    private static List<Car> inputCars(Scanner scanner) {
        System.out.println("경주에 참여할 자동차 이름을 입력하세요. (이름은 5자 이하, 쉼표(,)로 구분): ");
        return getValidCars(scanner);
    }

    private static List<Car> getValidCars(Scanner scanner) {
        String input = scanner.nextLine();

        if (isValidInput(input)) {
            return parseCarNames(input);
        }

        System.out.println("입력값이 유효하지 않습니다. 다시 시도하세요.");
        return getValidCars(scanner);
    }

    private static boolean isValidInput(String input) {
        try {
            parseCarNames(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static List<Car> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private static int inputRound(Scanner scanner) {
        System.out.println("진행할 라운드 횟수를 입력하세요: ");
        return getValidRound(scanner);
    }

    private static int getValidRound(Scanner scanner) {
        String input = scanner.nextLine();

        if (isPositiveNumber(input)) {
            return Integer.parseInt(input);
        }

        System.out.println("1 이상의 숫자를 입력하세요.");
        return getValidRound(scanner);
    }

    private static boolean isPositiveNumber(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return false;
        }
    }

    private static void printWinners(List<Car> winners) {
        String names = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승 차량: " + names);
    }
}
