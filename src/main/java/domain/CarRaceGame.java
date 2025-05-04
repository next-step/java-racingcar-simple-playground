package domain;

import java.util.List;
import util.RandomNumberGenerator;

public class CarRaceGame {
    private final List<Car> cars;
    private List<String> winnerCarNames;

    public CarRaceGame(List<Car> cars){
        this.cars = cars;
    }

    public void start(int gameRounds){
        playRounds(gameRounds);
        int maxDistance = getMaxDistanceFromCars();
        winnerCarNames = getWinnerCarNames(maxDistance);
    }

    private void playRounds(int gameRounds) {
        for(int i=0; i< gameRounds; i++){
            cars.forEach(car -> car.tryMoveByNumber(RandomNumberGenerator.generate()));
        }
    }

    private int getMaxDistanceFromCars() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }

    private List<String> getWinnerCarNames(int maxDistance) {
        return cars.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName).toList();
    }

    public List<String> getWinnerCarNames() {
        return winnerCarNames;
    }
}
