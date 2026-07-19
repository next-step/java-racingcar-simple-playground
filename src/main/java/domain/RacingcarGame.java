package domain;

import java.util.*;

public class RacingcarGame {
    private final List<Car> cars;
    private int moveCount;

    public RacingcarGame(String[] names, NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        putNamesToList(names, numberGenerator);
    }

    private void putNamesToList(String[] names, NumberGenerator numberGenerator) {
        for (int i = 0; i < names.length; i++) {
            Car car = new Car(names[i], numberGenerator);
            cars.add(car);
        }
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
         return this.moveCount;
    }

    public List<Car> getCars() {
       return new ArrayList<>(this.cars);
    }

    public void addDistance() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int max = compare();

        for (Car car : cars) {
            putWinner(max, car, winners);
        }
        return winners;
    }

    private int compare() {
        int max = 0; 
        for (Car car : cars) {
            max = maxDistance(max, car);
        }
        return max;
    }

    private int maxDistance(int max, Car car) {
        if (max < car.getTotalDistance()) {
            max = car.getTotalDistance();
        }
        return max;
    }

    private void putWinner(int max, Car car, List<Car> winners) {
        if (max == car.getTotalDistance()) {
            winners.add(car);
        }
    }
}
