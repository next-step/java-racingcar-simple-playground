import domain.Car;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import view.CarNameInput;
import view.RaceOutput;
import view.RaceTrialNumberInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INITIAL_LOCATION = 0;

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = createCars(new CarNameInput(scanner).getCarName());
        int trialNumber = getTrialNumber(scanner);

        race(cars, trialNumber);
    }

    private List<Car> createCars(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(name -> new Car(name, INITIAL_LOCATION))
                .toList();
    }

    private int getTrialNumber(Scanner scanner) {
        return Integer.parseInt(new RaceTrialNumberInput(scanner).getRaceTrialNumber());
    }

    private void race(List<Car> cars, int trialNumber) {
        RaceOutput raceOutput = new RaceOutput();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        raceOutput.showResultMessage();
        for (int count = 0; count < trialNumber; count++) {
            moveCars(cars, numberGenerator);
            raceOutput.showResult(cars);
        }
    }

    private void moveCars(List<Car> cars, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.moveCar(numberGenerator.getNumber());
        }
    }
}
