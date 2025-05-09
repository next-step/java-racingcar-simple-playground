import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumberProvider numberProvider;

    public RacingGame(List<Car> cars, RandomNumberProvider numberProvider) {
        this.cars = cars;
        this.numberProvider = numberProvider;
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
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public List<Car> getWinners() {
        return new GetWinner().decideWinner(cars);
    }
}
