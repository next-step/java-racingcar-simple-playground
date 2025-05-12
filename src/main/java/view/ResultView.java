package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class ResultView {

    public static void printStart() {
        System.out.println("\n실행 결과");
    }
    public static void printRound(Cars cars) {
        for (Car car : cars.getCars()) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()));
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(", ", winners))
                .append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
