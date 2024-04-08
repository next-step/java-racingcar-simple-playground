package controller;

import controller.RandomNumberGenerator;
import model.Car;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    ArrayList<Car> cars = new ArrayList<>();
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private ResultView resultView = new ResultView();
    /**
     * n개의 자동차가 t번 moving
     */
    public void racing(int n, int t, ArrayList<String> names) {
        validateName(names);
        initCars(names);
        printAllCarDistances();
        for (int i = 0; i < t; i++) {
            eachRacing();
            printAllCarDistances();
        }
    }

    private void validateName(ArrayList<String> names) {
        boolean isInvalid = names.stream()
                .anyMatch(name -> name.isEmpty() || name.length() > 5);

        if (isInvalid) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없으며, 5자를 초과할 수 없습니다.");
        }
    }


    public void initCars(ArrayList<String> names) {
        cars.clear();
        for (String name : names) {
            cars.add(new Car(name, 1, randomNumberGenerator)); // 초기 거리는 0으로 시작
        }
    }
    void printAllCarDistances() {
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
                .collect(Collectors.toList());
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