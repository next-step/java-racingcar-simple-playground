package service;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    //cars 배열 내의 객체들 움직이기
    public void moveCarList() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    //주어진 횟수만큼 차 움직이기
    public RacingCars playRound(int roundcnt) {
        for (int i = 0; i < roundcnt; i++) {
            moveCarList();
            printCarsMoving();
        }
        return this;
    }

    //우승 차 구하기
    public List<Car> getWinner() {
        int maxLocation = getMaxLocation();
        return getCarsAtLocation(maxLocation);
    }

    public int getMaxLocation() {
        return cars.stream()
                .mapToInt(car -> car.getLocation())
                .max()
                .getAsInt();
    }

    public List<Car> getCarsAtLocation(int location) {
        return cars.stream()
                .filter(car -> car.getLocation() == location)
                .toList();

    }

    public RacingCars printWinner() {
        List<Car> winners = getWinner();
        String names = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
        System.out.println(names + "가 최종 우승했습니다");

        return this;
    }

    public void printCarsMoving() {
        for (Car car : cars) {
            String bar = "-".repeat(car.getLocation());
            System.out.println(car.getName() + ": " + bar);
        }

        System.out.print("\n");
    }
}
