package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import view.ResultView;

public class RacingGame {

    private final List<Car> carList;

    public RacingGame(List<Car> carList) {
        this.carList = carList;
    }

    public void startRace(int tryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            moveCar();
            ResultView.printResult(carList);
        }
    }

    public void moveCar() {
        Random random = new Random();
        for (Car car : carList) {
            car.move(random.nextInt(10));
        }
    }

    public List<Car> getWinners() {
        int max = findMaxPosition();
        return carList.stream()
            .filter(car -> car.getPosition() == max)
            .toList();
    }

    public int findMaxPosition() {
        var a = carList.stream()
            .map(Car::getPosition)
            .toList();
        return Collections.max(a);
    }
}
