package controller;

import controller.RandomNumberGenerator;
import model.Car;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private ArrayList<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final ResultView resultView = new ResultView();

    public void racing(int carNumber, int movingNumber, ArrayList<String> names) {
        initCars(names);
        printAllCarDistances();
        for (int i = 0; i < movingNumber; i++) {
            eachRacing();
            printAllCarDistances();
        }
    }

    public void initCars(ArrayList<String> names) {
        cars.clear();
        for (String name : names) {
            cars.add(new Car(name, 1, randomNumberGenerator)); // 초기 거리는 1으로 시작
        }
    }
    public void printAllCarDistances() {
        for (Car car : cars) {
            resultView.printCarDistance(car); // 각 차량의 현재 위치 출력
        }
        System.out.println();
    }

    /**
     * 각각의 차들 움직여주기
     */
    public void eachRacing() {
        for (Car car : cars) {
            car.moving();
        }
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public void addCar(String name, int distance) {
        cars.add(new Car(name, distance, randomNumberGenerator));
    }
}