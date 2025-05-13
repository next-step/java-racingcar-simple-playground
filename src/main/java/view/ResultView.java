package view;

import domain.CarInfo;

import java.util.List;

public class ResultView {

    public static void printStart() {
        System.out.println("\n실행 결과");
    }

    public static void printRound(List<CarInfo> carDTOs) {
        for (CarInfo car : carDTOs) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.name())
                    .append(" : ")
                    .append("-".repeat(car.position()));
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
