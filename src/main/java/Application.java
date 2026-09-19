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
        game.race(
                rounds,
                () -> ResultView.printCars(cars)
        );
        ResultView.printWinners(game.getWinners());
    }

    private static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
