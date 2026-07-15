package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<RacingCar> cars;
    private int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    public List<RacingCar> createCars(List<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public int randomNum() {
        Random random = new Random();
        int num = random.nextInt(10);
        return num;
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.move(randomNum());
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int findMaxDistance(List<RacingCar> cars) {
        int maxDistance = 0;
        for (RacingCar car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public void findWinner(RacingCar car, int maxDistance, List<RacingCar> winners) {
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