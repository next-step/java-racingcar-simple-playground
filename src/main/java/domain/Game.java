package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final WinnerFinder winnerFinder;
    private final CarManager carManager;

    public Game(CarManager carManager) {
        this.carManager = carManager;
        winnerFinder = new WinnerFinder();
    }

    public void addCar(Car car) {
        carManager.addCar(car);
    }

    public List<Car> findWinner() {
        List<Car> cars = carManager.findAllCar();
        return winnerFinder.findWinner(cars);
    }

    public void turn() {
        carManager.moveIfCan();
    }

    public List<Car> findAllCar() {
        return carManager.findAllCar();
    }
}
