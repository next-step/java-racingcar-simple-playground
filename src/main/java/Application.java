import domain.Car;
import domain.Cars;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import domain.RacingGame;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        String[] names = inputView.readCarNames();
        Cars cars = createCars(names);

        int raceCount = inputView.readRaceCount();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingGame racingGame = new RacingGame(cars, numberGenerator);

        runRaceAndPrintResults(raceCount, racingGame, cars, outputView);

        outputView.printWinners(cars.findWinners());
    }

    private static Cars createCars(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            carList.add(car);
        }

        Cars cars = new Cars(carList);

        return cars;
    }

    private static void runRaceAndPrintResults(
            int raceCount,
            RacingGame racingGame,
            Cars cars,
            OutputView outputView
    ) {
        outputView.printResultHeader();
        for (int i = 0; i < raceCount; i++) {
            racingGame.race();
            outputView.printCars(cars);
        }

        outputView.printCars(cars);
    }
}
