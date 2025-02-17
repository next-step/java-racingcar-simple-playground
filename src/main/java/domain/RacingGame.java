package domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final int rounds;
    private Random random;

    public RacingGame(String[] carsName, int rounds) {
        this.cars = createCars(carsName);
        this.rounds = rounds;
    }

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public RacingGame(String[] carsName, int rounds, Random random) {
        this.cars = createCars(carsName);
        this.rounds = rounds;
        this.random = random;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void gameStart() {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            System.out.println();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            int randomValue = random.nextInt(10);
            car.move(randomValue);
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public String findWinnerName(List<Car> winnerCars) {
        return winnerCars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }
}
