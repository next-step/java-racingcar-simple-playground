package domain;

import java.util.*;

public class RacingcarGame {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    private int moveCount;

    public RacingcarGame(String[] names, NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        putNamesToList(names);
    }

    private void putNamesToList(String[] names) {
        for (int i = 0; i < names.length; i++) {
            Car car = new Car(names[i]);
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
            int randomValue = numberGenerator.getNumber();
            car.move(randomValue);
        }
    }

    public List<Car> getWinner() {
        int max = cars.stream()
                .mapToInt(car -> car.getTotalDistance())
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getTotalDistance() == max)
                .toList();
    }
}
