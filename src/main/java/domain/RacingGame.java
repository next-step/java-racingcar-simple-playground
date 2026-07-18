package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int tryCount;
    private final NumberGenerator numberGenerator;

    public RacingGame(List<String> carNames, int tryCount) {
        this(carNames, tryCount, () -> new Random().nextInt(10));
    }

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
    }

    private List<RacingCar> createCars(List<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private int findMaxDistance(List<RacingCar> cars) {
        int maxDistance = 0;
        for (RacingCar car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private void findWinner(RacingCar car, int maxDistance, List<RacingCar> winners) {
        if (maxDistance == car.getDistance()) {
            winners.add(car);
        }
    }

    public List<RacingCar> whoWin(List<RacingCar> cars) {
        int maxDistance = findMaxDistance(cars);
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            findWinner(car, maxDistance, winners);
        }
        return winners;
    }
}
