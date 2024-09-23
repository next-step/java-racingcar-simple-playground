package view;

import domain.Car;

import java.util.List;

public class ResultView {
    static public void printWinners(List<Car> winners) {
        String carNames = "";
        for (int i = 0; i < winners.size(); i++) {
            carNames += winners.get(i).getName();

            if (i != winners.size() - 1) {
                carNames += ", ";
            }
        }

        System.out.println(carNames + "가 최종 우승했습니다");
    }
}
