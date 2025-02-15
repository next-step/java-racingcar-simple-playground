package view;

import model.Car;
import model.FormattingGenerator;
import java.util.List;

public class ResultView implements FormattingGenerator {

    public static void printRaceResult() {
        System.out.println("실행 결과");
    }

    public static void printRaceStatus(List<Car> cars) {
        System.out.println(new ResultView().formatRaceStatus(cars));
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(new ResultView().formatWinners(winners));
    }
}
