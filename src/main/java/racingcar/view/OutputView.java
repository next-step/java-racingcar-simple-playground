package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));

        }
    }
    public void printWinner(List<Car> cars){
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        String winnerName = String.join(", ", names);
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
