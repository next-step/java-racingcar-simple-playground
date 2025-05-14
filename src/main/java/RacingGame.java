import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumberProvider numberProvider;
    private final int round;

    public RacingGame(List<String> carNames, RandomNumberProvider numberProvider, int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
        }
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.numberProvider = numberProvider;
        this.round = round;
    }

    public void play(int round) {
        for (int i = 0; i < round; i++) {
            raceOnce();
            printRoundResult();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            car.move(numberProvider.getRandomNumber());
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public List<Car> getWinners() {
        return new CarRaceResultAnalyzer().decideWinner(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
