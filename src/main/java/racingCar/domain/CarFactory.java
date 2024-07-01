package racingCar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.NumberGenerator;

public class CarFactory {

    private final String carInput;
    private final NumberGenerator numberGenerator;
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winner = new ArrayList<>();

    public CarFactory(String carInput, NumberGenerator numberGenerator) {
        this.carInput = carInput;
        this.numberGenerator = numberGenerator;
    }

    public List<Car> makeCars() {
        List<String> carList = Arrays.stream(carInput.split(",")).toList();

        for (String carName : carList) {
            cars.add(new Car(carName, numberGenerator));
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
