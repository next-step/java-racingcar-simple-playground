package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;

public class ResultView {

    public static void printLapResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner stringJoiner = new StringJoiner(", "); //의도를 드러내는 변수명으로 수정
        for (Car car : winners) {
            stringJoiner.add(car.getName());
        }
        System.out.print(stringJoiner + "가 최종 우승했습니다.");
    }
}
