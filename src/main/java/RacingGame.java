import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = new Cars(cars);
        this.numberGenerator = numberGenerator;
    }

    public void race(int count) {
        for (int i = 0; i < count; i++) {
            cars.move(numberGenerator);
        }
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
