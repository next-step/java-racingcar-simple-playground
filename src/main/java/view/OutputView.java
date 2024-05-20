package view;

import static util.Constants.FORMAT_OF_WINNERS;

import java.util.List;
import java.util.Map;
import util.Constants;

public class OutputView {

    StringBuilder sb;
    public OutputView() {
        sb = new StringBuilder();
    }

    public void printNamesInputGuide() {
        System.out.println(Constants.NAMES_INPUT_GUIDE);
    }

    public void printTryCountInputGuide() {
        System.out.println(Constants.TRY_COUNT_INPUT_GUIDE);
    }

    public void printResultStartGuide() {
        System.out.println(Constants.RESULT_PRINT_START_GUIDE);
    }

    public void printGameStatus(Map<String, Integer> locationByName, List<String> participantNames) {
        System.out.println(getGameStatus(locationByName, participantNames));
    }

    private String getGameStatus(Map<String, Integer> locationByName, List<String> participantNames) {
        sb.setLength(0);

        String location;
        for (String name : participantNames) {
            location = getStringOfLocation(locationByName.get(name));
            sb.append(String.format(Constants.FORMAT_OF_GAME_STATUS, name, location))
                .append("\n");
        }
        return sb.toString();
    }

    private String getStringOfLocation(int location) {
        return Constants.SYMBOL_OF_STATUS.repeat(location);
    }

    public void printGameWinners(List<String> winnerNames) {
        String joinedWinnerNames = String.join(Constants.WINNER_NAME_DELIMITER, winnerNames);
        System.out.printf((FORMAT_OF_WINNERS) + "%n", joinedWinnerNames);
    }

    public void printError(Exception e) {
        System.out.println(Constants.DEFAULT_ERROR_MESSAGE + e.getMessage());
    }
}
