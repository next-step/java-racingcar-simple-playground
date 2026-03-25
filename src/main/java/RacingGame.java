import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    List<Car> cars = new ArrayList<>();
    int count;

    public RacingGame(List<Car> newCars, int newcount) {
        this.cars = newCars;
        this.count = newcount;
    }

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private void moveCars() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }

    private void showRace() {
        for (Car car : cars) {
            String dash = "-".repeat(car.getPosition());
            System.out.println(car.getName() + ": " + dash);
        }
        System.out.println(" ");
    }

    private void showResult() {
        RaceResult raceResult = new RaceResult(cars);
        List<Car> winners = raceResult.getResult();
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.printf(winnerNames + "가 최종 우승했습니다.");
    }

    public void playGame() {
        for (int i = 0; i < count; i++) {
            moveCars();
            showRace();
        }
        showResult();
    }
}
