package view;

import domain.Car;

import java.util.List;

public class OutputView {

    public static void printWinnerCarNames(List<Car> winnnerCars) {
        String winnerCarsPrintFormat = "";
        for (Car currentCar : winnnerCars) {
            winnerCarsPrintFormat += currentCar.getCarName() + ", ";
        }
        System.out.println(winnerCarsPrintFormat.substring(0, winnerCarsPrintFormat.length() - 2) + "가 최종 우승했습니다.");
    }
}