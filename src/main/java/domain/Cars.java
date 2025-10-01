package domain;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public Car[] getCars() {
        return cars.toArray(new Car[0]);
    }

    public StringBuilder findWinnerNames() {
        WinnerFinder winnerFinder = new WinnerFinder();
        return winnerFinder.findWinners(cars);
    }
}
