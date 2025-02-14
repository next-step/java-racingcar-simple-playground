package view;

import java.util.List;

import domain.Car;
import domain.Game;

public class ResultView {

    public static void outputResult(Game game) {
        outputCarPosition(game.getCarGroup().getCars());
        outputWinner(game.getWinners());
    }

    private static void outputCarPosition(List<Car> cars) {
        System.out.println();
        System.out.println("실행결과");
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static void outputWinner(List<Car> winnerCars) {
        List<String> winnerNames = getWinnerCarNames(winnerCars);
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winnerNames));
    }

    private static List<String> getWinnerCarNames(List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .toList();
    }
}
