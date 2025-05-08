import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void run() {
        cars.moveAll();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
