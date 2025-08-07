package domain;

import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<String> carNames, int rounds) {
        validateRounds(rounds);
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    private void validateRounds(int rounds) {
        if (rounds < 0) {
            throw new IllegalArgumentException("경주 횟수는 0 이상이어야 합니다");
        }
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        for (int i = 0; i < rounds; i++) {
            moveAllCars();
        }
    }

    public void playOneRound() {
        moveAllCars();
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        if (cars.isEmpty()) {
            return new ArrayList<>();
        }
        int maxPosition = findMaxPosition();
        return findCarsAtPosition(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findCarsAtPosition(int targetPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addCarIfAtPosition(car, targetPosition, winners);
        }
        return winners;
    }

    private void addCarIfAtPosition(Car car, int targetPosition, List<String> winners) {
        if (car.getPosition() == targetPosition) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
