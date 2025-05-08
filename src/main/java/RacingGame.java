import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void run() {
        Output.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            Output.printStatus(cars);
        }
        Output.printWinners(getWinnerNames());
    }

    private List<String> getWinnerNames() {
        return cars.getWinners().stream().map(Car::getName).toList();
    }
}
