package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    public static void printLapResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner sj = new StringJoiner(", ");
        for (Car car : winners) {
            sj.add(car.getName());
        }
        System.out.print(sj + "가 최종 우승했습니다.");
    }
}
