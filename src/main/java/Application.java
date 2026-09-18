import domain.Car;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = InputView.readCars(scanner);
        int rounds = InputView.readValidRounds(scanner);

        RacingGame game = new RacingGame(cars, new RandomNumberGenerator());
        ResultView.printStart();
        runRace(game, cars, rounds);
        ResultView.printWinners(game.getWinners());
    }

    private static void runRace(RacingGame game, List<Car> cars, int rounds) {
        for (int round = 0; round < rounds; round++) {
            game.race(1);
            ResultView.printCars(cars);
        }
    }
}
