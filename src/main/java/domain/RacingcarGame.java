package domain;

import java.util.*;

public class RacingcarGame {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    private int totalRound;
    private int currentRound = 0;

    public RacingcarGame(String[] names, NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        putNamesToList(names);
    }

    private void putNamesToList(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void setTotalRound(int totalRound) {
        this.totalRound = totalRound;
    }

    public List<Car> getCars() {
       return new ArrayList<>(this.cars);
    }

    private void addDistance() {
        for (Car car : cars) {
            int randomValue = numberGenerator.getNumber();
            car.move(randomValue);
        }
    }

    public void playRound() {
        addDistance();
        currentRound++;
    }

    public boolean isFinished() {
        return totalRound == currentRound;
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
