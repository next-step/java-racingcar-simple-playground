import generator.NumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Circuit {

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator generator;

    public Circuit(final NumberGenerator generator) {
        this.generator = generator;
    }

    public void registerCars(final List<String> carNames) {
        cars.addAll(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public void startRace(final int raceTryCount) {
        for (int i = 0; i < raceTryCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveForward(generator.generateNumber());
        }
    }

    public List<Car> findWinners() {
        int winnerPosition = findWinnerPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .toList();
    }

    private int findWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
