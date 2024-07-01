package racingCar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private final String carInput;
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winner = new ArrayList<>();

    public CarFactory(String carInput) {
        this.carInput = carInput;
    }

    public List<Car> makeCars() {
        List<String> carList = Arrays.stream(carInput.split(",")).toList();

        for (String carName : carList) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<Car> getWinner() {
        int maxPos = findMaxPosition();

        for (Car car : cars) {
            if (car.position == maxPos) {
                winner.add(car);
            }
        }

        return winner;
    }

    private int findMaxPosition() {
        int max = 0;

        for (Car car : cars) {
            if (car.position > max) {
                max = car.position;
            }
        }

        return max;
    }
}
