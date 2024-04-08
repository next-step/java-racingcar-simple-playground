package view;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public void printCarDistance(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String names= String.join(", ", winners);
        System.out.println(names +"가 최종 우승했습니다.");
    }


}