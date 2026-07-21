package view;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    private static void printDistance(Car car) {
        for (int i = 0; i < car.getTotalDistance(); i++) {
            System.out.print("-");
        }
    }

    public static void printCarDistance(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            ResultView.printDistance(car);
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {

        StringJoiner joiner = new StringJoiner(", ");

        for (Car car : winners) {
            joiner.add(car.getName());
        }
        System.out.println(joiner + "가 최종 우승했습니다.");
    }
}
