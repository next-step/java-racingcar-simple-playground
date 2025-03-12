package CarGame2;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final int rounds;

    public Race(List<String> carNames, int rounds) {
        this.rounds = rounds;
        createCars(carNames);
    }

    private void createCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            playRound(i + 1);
        }
        printWinners();
    }

    private void playRound(int curRound) {
        System.out.println("ROUND " + curRound);
        for (Car car : cars) {
            car.move();
            printCarStatus(car);
        }
        System.out.println("-------------------");
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + " 자동차 이동거리: " + car.getSpeed() + " [현재 위치: " + car.getPosition() + "]");
    }

    private void printWinners() {
        FindWinner findWinner = new FindWinner(cars);
        List<String> winners = findWinner.getWinners();
        System.out.println("우승한 자동차: " + String.join(", ", winners));
    }
}
