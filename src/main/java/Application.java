import domain.Car;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = InputView.readCarNames(scanner);
        List<Car> cars = createCars(names);
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

    private static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
