package view;

import domain.Car;

import java.util.List;

public class RacingGameResultView {

    private static final String WINNER_FORMAT_SEPARATOR = ", ";

    public void printWinners(List<Car> winners) {
        String output = formatWinnerNames(winners) + "가 최종 우승했습니다.";

        System.out.println(output);
    }

    private String formatWinnerNames(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car winner : winners) {
            stringBuilder.append(winner.getName())
                    .append(WINNER_FORMAT_SEPARATOR);
        }
        stringBuilder.delete(stringBuilder.length() - WINNER_FORMAT_SEPARATOR.length(), stringBuilder.length());

        return stringBuilder.toString();
    }
}
