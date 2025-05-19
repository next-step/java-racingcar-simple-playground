import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import utils.NumberGenerator;
import utils.RandomNumberGenerator;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = null;
        boolean validName = false;

        while (!validName) {
            System.out.println("경주에 참여할 자동차 이름을 입력하세요. (이름은 5자 이하, 쉼표(,)로 구분): ");
            String input = scanner.nextLine();

            try {
                cars = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Car::new)
                    .collect(Collectors.toList());
                validName = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int round = 0;

        System.out.println("진행할 라운드 횟수를 입력하세요: ");

        while (round <= 0) {
            try {
                round = Integer.parseInt(scanner.nextLine());
                if (round <= 0) {
                    System.out.println("1 이상의 숫자를 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }

        NumberGenerator generator = new RandomNumberGenerator();
        RacingGame racingGame = new RacingGame(generator, cars);
        racingGame.play(round);

        List<Car> winners = racingGame.getWinners();
        System.out.println("최종 우승 차량:" + winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}
