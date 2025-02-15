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

    public List<Car> getCars() {
        return cars;
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

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public void determineWinners() {
        int maxPosition = getMaxPosition(cars);
        winnerCarNames = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerCarNames() {
        return winnerCarNames;
    }

}
