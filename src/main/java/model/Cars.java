package model;

import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> cars;

    public Cars(Random random, List<String> carNames) {
        this.cars = carNames.stream()
                .map(carName -> new Car(carName, random))
                .toList();
        
    }

    public void allMove(){
        cars.forEach(Car::move);
    }

    public int findMaxDistance(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
