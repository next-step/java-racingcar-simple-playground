package view;

import dto.RaceResultInfoDto;

public class RacingGameResultView implements RacingGameView {

    private static final String WINNER_FORMAT_SEPARATOR = ", ";

    public void printWinners(RaceResultInfoDto resultInfoDto) {
        String output = formatWinnerNames(resultInfoDto) + "가 최종 우승했습니다.";

        System.out.println(output);
    }

    private String formatWinnerNames(RaceResultInfoDto resultInfoDto) {
        StringBuilder winnerNameFormatter = new StringBuilder();

        for (String winnerName : resultInfoDto.getWinnerNames()) {
            winnerNameFormatter.append(winnerName)
                    .append(WINNER_FORMAT_SEPARATOR);
        }
        winnerNameFormatter.delete(winnerNameFormatter.length() - WINNER_FORMAT_SEPARATOR.length(), winnerNameFormatter.length());

        return winnerNameFormatter.toString();
    }

}
