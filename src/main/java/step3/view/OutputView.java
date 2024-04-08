package step3.view;

import step3.domain.Car;

import java.util.List;

public class OutputView {

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceScore(List<Car> cars) {
        for(Car car: cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printRaceWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
