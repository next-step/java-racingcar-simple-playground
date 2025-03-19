package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final WinnerFinder winnerFinder;
    private final CarManager carManager;
    private final List<List<Car>> gameHistory;

    public Game(CarManager carManager) {
        this.carManager = carManager;
        winnerFinder = new WinnerFinder();
        gameHistory = new ArrayList<>();
    }

    public void addCar(Car car) {
        carManager.addCar(car);
    }

    public List<Car> findWinner() {
        List<Car> cars = carManager.findAllCar();
        return winnerFinder.findWinner(cars);
    }

    public void gameStart(int turnCount) {
        if (turnCount <= 0) {
            throw new IllegalArgumentException("턴의 수는 1이상이어야 합니다.");
        }
        for (int i = 0; i <turnCount; i++) {
            turn();
        }
    }

    public void turn() {
        carManager.moveIfCan();
        addCarHistoryToGameHistory();
    }

    private void addCarHistoryToGameHistory() {
        List<Car> carsHistory = new ArrayList<>();
        List<Car> cars = findAllCar();
        for (Car car : cars) {
            carsHistory.add(new Car(car));
        }
        gameHistory.add(carsHistory);
    }

    public List<List<Car>> getGameHistory() {
        return gameHistory;
    }

    public List<Car> findAllCar() {
        return carManager.findAllCar();
    }
}
