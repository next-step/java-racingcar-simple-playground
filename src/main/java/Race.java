import java.util.List;

public class Race {

    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void progress(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
        }
    }

    public List<Car> findWinners() {
        int maximum = cars.findMaximum();
        return cars.filterByPosition(maximum);
    }
}
