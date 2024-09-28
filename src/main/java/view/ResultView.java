package view;

import domain.car.Cars;

public class ResultView {

    public void printExecutionResultsMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getCarPosition()));
        });
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }

}
