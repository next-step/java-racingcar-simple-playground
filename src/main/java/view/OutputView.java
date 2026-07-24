package view;

import java.util.List;
import java.util.StringJoiner;

import domain.Car;

public class OutputView {
    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<Car> winners) {
        StringJoiner winnerNames = new StringJoiner(", ");

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
