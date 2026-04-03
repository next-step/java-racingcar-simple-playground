import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> findWinners() {
        Car maxCar = getMaxPositionCar();
        return getSamePositionCars(maxCar);
    }

    private List<Car> getSamePositionCars(final Car maxCar) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winners, car, maxCar);
        }
        return winners;
    }

    private void addIfWinner(final List<Car> winners, final Car car, final Car maxCar) {
        if (car.isSamePosition(maxCar)) {
            winners.add(car);
        }
    }

    private Car getMaxPositionCar() {
        Car maxCar = cars.get(0);
        for (Car car : cars) {
            maxCar = compareAndGetMax(maxCar, car);
        }
        return maxCar;
    }

    private Car compareAndGetMax(final Car maxCar, final Car car) {
        if (car.getPosition() > maxCar.getPosition()) {
            return car;
        }
        return maxCar;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }
}