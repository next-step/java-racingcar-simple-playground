package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();


    public RacingGame(List<Car> newCars) {
        this.cars = newCars;

    }

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void playRound() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }
    public List<Car> getCars(){
        return cars;
    }
    public int getMaxposition(){
        int maxPosition=cars.stream().
                mapToInt(Car::getPosition).max()
                .orElse(0);
        return maxPosition;
    }
    public List<Car> getResult() {
        List<Car> resultCars = new ArrayList<>();
        int maxPosition = getMaxposition();
        resultCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
        return resultCars;
    }

}
