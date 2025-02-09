package view;

import domain.Race;
import domain.RacingCar;

import java.util.List;

public class ResultView {
    public static void printRaceResults(Race race) {
        System.out.println("\n실행 결과:");
        for (RacingCar car : race.getCars()) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition())); // 위치만큼 '-' 출력
        }
    }

    public static void printWinners(List<RacingCar> winners) {
        System.out.println(String.join(", ", getWinnerNames(winners)) + "가 최종 우승했습니다.");
    }

    private static List<String> getWinnerNames(List<RacingCar> winners) {
        return winners.stream()
                .map(RacingCar::getName)
                .toList();
    }
}
