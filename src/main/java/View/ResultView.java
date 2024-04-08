package View;

import Model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printResult(List<Car> carList){
        for (Car c : carList) {
            System.out.println(c.getCarName()+" : "+ "-".repeat(c.getPosition()));
        }
        System.out.println();
    }
    public static void printWinners(List<String> winners) {
        if (!winners.isEmpty()) {
            System.out.println("실행 결과");
            System.out.println(winners.stream()
                    .collect(Collectors.joining(", ", "", "가 최종 우승했습니다.")));

        }
    }
}
