import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameView {

    public List<Car> inputCars() {
        System.out.println("경주에 참여할 자동차 이름을 입력하세요. (이름은 5자 이하, 쉼표(,)로 구분): ");
        return getValidCars();
    }

    public List<Car> getValidCars() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isValidInput(input)) {
            return parseCarNames(input);
        }

        System.out.println("입력값이 유효하지 않습니다. 다시 시도하세요.");
        return getValidCars();
    }

    public boolean isValidInput(String input) {
        try {
            parseCarNames(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Car> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public int inputRound() {
        System.out.println("진행할 라운드 횟수를 입력하세요: ");
        return getValidRound();
    }

    public int getValidRound() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isPositiveNumber(input)) {
            return Integer.parseInt(input);
        }

        System.out.println("1 이상의 숫자를 입력하세요.");
        return getValidRound();
    }

    public boolean isPositiveNumber(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return false;
        }
    }

    public void printWinners(List<Car> winners) {
        String names = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승 차량: " + names);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

}
