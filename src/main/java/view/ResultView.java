package view;

import domain.Car;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ResultView {
    public static void printRound(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(ArrayList<Car> winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Car car : winners) {
            joiner.add(car.getName());
        }
        System.out.println(joiner + "가 최종 우승했습니다!");
    }
}
