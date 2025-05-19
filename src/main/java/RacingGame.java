import java.util.List;
import java.util.stream.Collectors;

import utils.NumberGenerator;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    public RacingGame(NumberGenerator numberGenerator, List<Car> cars) {
	    this.numberGenerator = numberGenerator;
	    this.cars = cars;
    }

    public void play(int round) {
        for (int i = 0; i < round; i++) {
            moveForward();
        }
    }

    private void moveForward() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream()
            .mapToInt(Car::getDistance)
            .max()
            .orElse(0);
        return cars.stream()
            .filter(car -> car.getDistance() == maxDistance)
            .collect(Collectors.toList());
    }

}
