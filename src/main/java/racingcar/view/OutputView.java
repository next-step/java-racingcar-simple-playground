package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

    public void printInit() {
        System.out.println("실행 결과");
    }

    public void printMovement(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        List<String> carNames = winners.stream().map(Car::getName).toList();
        System.out.printf("%s가 최종 우승했습니다.%n", String.join(", ", carNames));
    }
}
