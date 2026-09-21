import java.util.ArrayList;

public class CarRace {
    private int maxPosition;
    private Cars cars;
    private ArrayList<Car> winners;
    private NumberGenerator numberGenerator;

    public CarRace(Cars cars, NumberGenerator numberGenerator) {
        validateCars(cars);

        maxPosition = 0;
        this.cars = cars;
        winners = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    private void validateCars(Cars cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 안 됨");
        }
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            car.moveCar(numberGenerator);
        }
    }

    public ArrayList<Car> getWinners() {
        findMaxPosition();
        findWinners();
        return winners;
    }

    private void findMaxPosition() {
        for (Car car : cars.getCars()) {
            maxPosition = car.getLargerPosition(maxPosition);
        }
    }

    private void findWinners() {
        for (Car car : cars.getCars()) {
            addWinners(car);
        }
    }

    private void addWinners(Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }
}
