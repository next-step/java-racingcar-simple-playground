package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.generator.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] items = input.split(",");

        List<Car> carList = Arrays.stream(items)
                .map(String::trim)
                .map(Car::new)
                .toList();

        Cars cars = new Cars(carList);
        RacingGame racingGame = new RacingGame(cars, new RandomNumberGenerator());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = scanner.nextInt();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            printRoundResult(racingGame.getCars());
        }

        printWinners(racingGame.getWinners());
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(names + "가 최종 우승했습니다.");
    }
}
