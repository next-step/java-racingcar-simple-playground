package view;

import domain.car.Cars;

import java.util.List;

public class ResultView {

    public static void printExecutionResultsMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getCarPosition()));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnersByPrintFormulation = String.join(",", winners);
        System.out.println(winnersByPrintFormulation + "가 최종 우승했습니다.");
    }

}
