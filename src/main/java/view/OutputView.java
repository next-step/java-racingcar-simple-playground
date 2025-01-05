package view;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printRaceStatus(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }

        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승하였습니다.");
    }
}
