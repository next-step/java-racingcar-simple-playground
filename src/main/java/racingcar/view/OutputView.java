package racingcar.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printMoveResults(final Map<Integer, Cars> roundRecords) {
        System.out.println("실행 결과");

        List<Integer> rounds = new ArrayList<>(roundRecords.keySet());
        rounds.sort(Comparator.naturalOrder());

        rounds.forEach(round -> printSingleMoveResult(roundRecords.get(round)));
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
