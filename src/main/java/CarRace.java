import java.util.ArrayList;

public class CarRace {
    private int maxPosition;
    private ArrayList<Car> cars;
    private ArrayList<Car> winners;
    private NumberGenerator numberGenerator;

    public CarRace(ArrayList<Car> cars, NumberGenerator numberGenerator) {
        validateCars(cars);

        maxPosition = 0;
        this.cars = cars;
        winners = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    private void validateCars(ArrayList<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 안 됨");
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveCar(numberGenerator);
        }
    }

    public ArrayList<Car> getWinners() {
        findMaxPosition();
        findWinners();
        return winners;
    }

    private void findMaxPosition() {
        for (Car car : cars) {
            maxPosition = car.getLargerPosition(maxPosition);
        }
    }

    private void findWinners() {
        for (Car car : cars) {
            addWinners(car);
        }
    }

    private void addWinners(Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }
}
