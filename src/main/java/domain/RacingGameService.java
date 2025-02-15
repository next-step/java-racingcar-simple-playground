import domain.Car;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameService {

    private List<Car> cars = new ArrayList<>();
    private List<Car> winnerCars = new ArrayList<>();
    private int rounds;

    public void carList(List<String> carNames) {
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void gameStart(int rounds) {
        this.rounds = rounds;
        while (rounds-- > 0) {
            moveCars();
            printRoundResults();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        winnerCars = cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
        return winnerCars;
    }

    public String findWinnerName() {
        return winnerCars.stream().map(car -> car.getName()).collect(Collectors.joining(", "));
    }
}
