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

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void determineWinner() {
        this.winners = cars.stream().filter(car -> car.getScore() == getMaxScore())
                .collect(Collectors.toList());
    }

    public int getMaxScore() {
        return cars.stream().mapToInt(Car::getScore).max().orElse(0);
    }

    public List<String> getCarNames() {
        return cars.stream().map(car -> car.getName()).collect(Collectors.toList());
    }

    public List<Integer> getCarScores() {
        return cars.stream().map(car -> car.getScore()).collect(Collectors.toList());
    }

    public List<String> getWinners() {
        determineWinner();
        return winners.stream().map(winner -> winner.getName()).collect(Collectors.toList());
    }

}
