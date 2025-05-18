package racinggame.model;
import racinggame.model.car.Car;
import racinggame.model.car.policy.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> names,MoveStrategy moveStrategy) {
        this.cars = createCars(names,moveStrategy);
    }

    private List<Car> createCars(List<String> names, MoveStrategy strategy) {
        return names.stream()
                .map(name -> new Car(name,strategy))
                .collect(Collectors.toList());
    }

    public void moveOneTurn() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners(){
        int maxDistance=findMaxDistance();
        
        return cars.stream()
                .filter(car->car.getMovedDistance()==maxDistance)
                .map(Car::getName).collect(Collectors.toList());
    }

    private int findMaxDistance(){
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElse(0);
    }
}
