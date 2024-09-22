package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public void printOneRoundResult(List<Car> cars){
        for (Car car : cars) {
            System.out.printf("%s : %s\n",car.getCarName(),"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(String winners){
        System.out.println(winners+"가 최종 우승했습니다.");
    }

    public void printString() {
        System.out.println("\n실행 결과");
    }
}
