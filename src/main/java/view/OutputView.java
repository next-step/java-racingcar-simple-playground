package view;

import domain.Car;

import java.util.List;

public final class OutputView {

    public void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRound(List<Car> cars) {
        for (Car car : cars) {
            printCarLine(car);
        }
        System.out.println();
    }

    private void printCarLine(Car car) {
        System.out.println(car.name() + " : " + "-".repeat(car.position()));
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}