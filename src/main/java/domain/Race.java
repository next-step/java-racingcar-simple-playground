package domain;

import utils.RandomDigitGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private int carCount;
    private int raceTurn;
    private RandomDigitGenerator randomDigitGenerator;

    public Race(int carCount, int raceTurn, RandomDigitGenerator randomDigitGenerator) {
        this.carCount = carCount;
        this.raceTurn = raceTurn;
        this.randomDigitGenerator = randomDigitGenerator;
    }

    public void playSingleTurn(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomDigitGenerator.generateRandomDigit());
        }
    }

    public List<Car> getWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream().filter(car -> car.getCarPosition() == maxPosition).collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getCarPosition());
        }
        return maxPosition;
    }

    public List<Car> playRace(List<Car> cars, int raceTurn) {
        for (int i = 0; i < raceTurn; i++) {
            playSingleTurn(cars);
        }
        return getWinner(cars);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRaceTurn() {
        return raceTurn;
    }
}
