package domain;

import exception.IllegalRandomVariableException;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static view.OutputView.printCarsInfo;

public class CarRace {

    private final List<Car> cars;
    private final int tryCount;

    public CarRace(String[] names, int tryCount, int carCount) {
        cars = new ArrayList<>();
        for(int i=0;i<carCount;i++) {
            cars.add(new Car(names[i]));
        }

        this.tryCount = tryCount;
    }

    public List<Car> findWinners(){
        int max = 0;
        // 가장 멀리간 자동차의 길이 구하기
        for (Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        int finalMax = max;
        return cars.stream().filter(car -> car.getDistance() == finalMax).toList();
    }

    public void raceOneLap() {
        for (Car car : cars) {
            int randomNumber = RandomValueGenerator.generate();
            car.moveOrStop(randomNumber);
        }
    }

    public int getTryCount(){
        return tryCount;
    }

    public List<Car> getCars(){
        return cars;
    }
}
