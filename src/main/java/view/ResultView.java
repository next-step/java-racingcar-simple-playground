package view;

import domain.CarInfo;

import java.util.List;

public class ResultView {

    public static void printStart() {
        System.out.println("\n실행 결과");
    }

    public static void printRound(List<CarInfo> carInfos) {
        for (CarInfo car : carInfos) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.name())
                    .append(" : ")
                    .append("-".repeat(car.position()));
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void printAllRounds(List<List<CarInfo>> raceHistory) {
        printStart();

        for (List<CarInfo> round : raceHistory) {
            printRound(round); // 이미 만든 1라운드 출력 재사용
        }
    }

    public static void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(", ", winners))
                .append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
