package domain;

import view.InputView;
import view.ResultView;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD_STANDARD = 4;

    private final List<Car> cars = new ArrayList<>();
    private List<String> carNames;
    private int raceAttemptCount;
    private List<String> winnerCarNames;

    private final ResultView printer = new ResultView();
    private final Random random = new Random();

    public void initializeRace() {
        carNames = InputView.getCarNames();
        raceAttemptCount = InputView.getTryCount();
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

    private boolean shouldMove() {
        return random.nextInt(RANDOM_BOUND) >= FORWARD_STANDARD;
    }

    private void moveCars() {
        cars.stream()
                .filter(car -> shouldMove())
                .forEach(Car::move);
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
