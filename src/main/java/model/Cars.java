package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    public Cars(final String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
    public void moveCarsForRaces(int raceCount){
        for(int i = 0; i < raceCount; i++) {
            move();
        }
    }

    public void move(){
        for (Car car : cars) {
            car.move();
        }
    }
    public void calculateWinner() {
        final int maxScore = cars.stream().mapToInt(Car::getScore).max().orElse(0);
        this.winners = cars.stream().filter(car -> car.getScore() == maxScore)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners(){
        calculateWinner();
        return winners;
    }

}
