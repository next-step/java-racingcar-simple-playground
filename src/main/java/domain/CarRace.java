package domain;

import java.util.List;

public class CarRace {
    private final List<Car> cars;
    private final int gameRounds;
    private List<String> winnerCarNames;
    private final NumberGenerator numberGenerator;

    public CarRace(List<Car> cars, int gameRounds, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.gameRounds = gameRounds;
        this.numberGenerator = numberGenerator;
    }

    public void start(){
        playRounds();
        int maxDistance = getMaxDistanceFromCars();
        winnerCarNames = getWinnerCarNames(maxDistance);
    }

    private void playRounds() {
        for(int i=0; i< gameRounds; i++){
            cars.forEach(car -> car.tryMoveByNumber(numberGenerator.generate()));
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
