package car.view;

import car.domain.MovingCar;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printRoundResult(List<MovingCar> cars) {
        for (MovingCar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    public static void printWinners(List<MovingCar> winners) {
        String winnerNames = winners.stream()
            .map(MovingCar::getName)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승자: " + winnerNames);
    }

}
