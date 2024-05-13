import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final int count;

    public RacingGame(final Cars cars, final int count) {
        this.cars = cars;
        this.count = count;
    }

    public void moveCars() {
        for (int i = 0; i < count; i++) {
            cars.move();
        }
    }

    public List<Car> getWinners() {
        final int maxPosition = cars.getMaxPosition();
        return cars.getMaxMoveCars(maxPosition);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
