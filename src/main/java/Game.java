import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> cars;
    private final int round;

    public Game(List<String> carNames, int round) {
        validateRoundIsPositive(round);
        this.cars = createCars(carNames);
        this.round = round;
    }

    private void validateRoundIsPositive(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("라운드는 1 이상이어야 합니다.");
        }
    }

    private List<Car> createCars(List<String> carNames) {
        return List.copyOf(
            carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            cars.forEach(Car::move);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
