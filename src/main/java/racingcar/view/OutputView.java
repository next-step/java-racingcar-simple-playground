package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printMoveResults(final List<Cars> carsSet) {
        System.out.println("실행 결과");
        carsSet.forEach(this::printSingleMoveResult);
        System.out.println();
    }

    private void printSingleMoveResult(Cars cars) {
        cars.cars()
                .stream()
                .map(c -> c.getName() + " : " + "-".repeat(c.getPosition()))
                .forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(final Cars winners) {
        String winnerMessage = String.join(
                ", ",
                winners.cars()
                        .stream()
                        .map(Car::getName)
                        .toList()
        );
        System.out.println(winnerMessage + "가 최종 우승했습니다.");
    }
}
