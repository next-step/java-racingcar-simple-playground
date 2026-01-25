package car.view;

import car.domain.model.MovingCar;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printExecutionResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<MovingCar> movingCars) {
        for (MovingCar movingCar : movingCars) {
            System.out.println(movingCar.getName() + " : " + "-".repeat(movingCar.getLocation()));
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
