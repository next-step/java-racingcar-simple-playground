package domain;

import utils.RandomDigitGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public int carCount;
    public int raceTurn;

    public Race(int carCount, int raceTurn) {
        this.carCount = carCount;
        this.raceTurn = raceTurn;
    }

    public void initRace(List<Car> cars) {
        for (Car car : cars) {
            car.carPosition = 0;
        }
    }

    public void playSingleTurn(List<Car> cars) {
        for (Car car : cars) {
            int randomDigit = new RandomDigitGenerator().generateRandomDigit();
            car.move(randomDigit);
        }
    }

    public List<Car> getWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream().filter(car -> car.carPosition == maxPosition).collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.carPosition);
        }
        return maxPosition;
    }

    public List<Car> playRace(List<Car> cars, int raceTurn) {
        initRace(cars);
        for (int i = 0; i < raceTurn; i++) {
            playSingleTurn(cars);
        }
        return getWinner(cars);
    }
}
