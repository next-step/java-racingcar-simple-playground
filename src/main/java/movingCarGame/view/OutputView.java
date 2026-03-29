package movingCarGame.view;

import java.util.List;
import java.util.stream.Collectors;
import movingCarGame.domain.Car;

public class OutputView {

    public void printResult() {
        System.out.println("실행결과");
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()))
        );
        System.out.println();
    }

    public void printFinalWinner(List<Car> cars) {
        String winnersName = cars.stream().map(Car::getName).collect(Collectors.joining(","));
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }
}
