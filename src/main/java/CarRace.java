import java.util.*;
import java.util.stream.Collectors;

public class CarRace {
    private final List<Car> cars = new ArrayList<>();
    private List<String> carNames;
    private int raceAttemptCount;
    private List<String> winnerCarNames;
    private final CarRaceResultPrinter printer = new CarRaceResultPrinter();

    public void initializeRace() {
        carNames = CarRaceInputHandler.getCarNames();
        raceAttemptCount = CarRaceInputHandler.getRaceAttemptCount();
        makeCarObjects();
    }

    private void makeCarObjects() {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void startRace() {
        for (int i = 0; i < raceAttemptCount; i++) {
            moveCars();
            printer.printRaceResult(cars);
        }
        determineWinners();
        printer.printWinnerCarNames(winnerCarNames);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private void determineWinners() {
        winnerCarNames = cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

}
