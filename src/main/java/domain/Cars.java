package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateNames(names);
        this.cars = createCars(names);
    }

    private void validateNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(
                    "자동차가 필요합니다."
            );
        }
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }

        return winners;
    }

    private void addWinner(
            Car car,
            int maxPosition,
            List<String> winners
    ) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private int findMaxPosition() {
        int maxPosition = START_POSITION;

        for (Car car : cars) {
            maxPosition = Math.max(
                    maxPosition,
                    car.getPosition()
            );
        }

        return maxPosition;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
