package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();
    public void save(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void calculateWinner() {
        final int maxScore = cars.stream().mapToInt(Car::getScore).max().orElse(0);
        winners = cars.stream().filter(car -> car.getScore() == maxScore)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners(){
        calculateWinner();
        return winners;
    }

}
