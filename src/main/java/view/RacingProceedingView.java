package view;

import domain.Car;

import java.util.List;

public class RacingProceedingView {

    public static void printTryingResult() {
        System.out.println("실행 결과");
    }

    public static void printProceedingRacingResult(List<Car> cars) {
        for (Car currentCar : cars) {
            System.out.println(currentCar.getCarName() + " : " + "-".repeat(currentCar.getCurrentDistance()));
        }
        System.out.println(" ");
    }
}
