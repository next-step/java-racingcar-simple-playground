package view;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        String result = String.join(", ", winnerNames) + " is(are) winners";
        System.out.println(result);
    }
}
