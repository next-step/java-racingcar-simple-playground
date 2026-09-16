import java.util.List;

public class Race {

    private Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int maximum = cars.findMaximum();
        return cars.filterByPosition(maximum);
    }
}