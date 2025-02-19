package view;

import domain.Car;
import java.util.List;

public class ResultView {
    public void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinnerCarNames(List<String> winnerCarNames) {
        System.out.println("실행 결과");
        System.out.print(String.join(", ", winnerCarNames));
        System.out.println("가 최종 우승했습니다.");
    }

}
