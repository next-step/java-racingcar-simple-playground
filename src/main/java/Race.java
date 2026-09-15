import java.util.List;

public class Race {
    private static final int MOVE_THRESHOLD = 4;
    private Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    static boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public List<Car> findWinners() {
        int maximum = cars.findMaximum();
        return cars.filterByPosition(maximum);
    }
}