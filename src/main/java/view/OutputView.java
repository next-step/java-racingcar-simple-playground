package view;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String WINNER_NAME_DELIMITER = ",";
    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR]";
    private static final String NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PRINT_START_GUIDE = "\n실행 결과";
    private static final String FORMAT_OF_GAME_STATUS = "%s : %s";
    private static final String SYMBOL_OF_STATUS = "-";
    private static final String FORMAT_OF_WINNERS = "%s가 최종 우승했습니다.";


    StringBuilder sb;

    public OutputView() {
        sb = new StringBuilder();
    }

    public void printNamesInputGuide() {
        System.out.println(NAMES_INPUT_GUIDE);
    }

    public void printTryCountInputGuide() {
        System.out.println(TRY_COUNT_INPUT_GUIDE);
    }

    public void printResultStartGuide() {
        System.out.println(RESULT_PRINT_START_GUIDE);
    }

    public void printGameStatus(Map<String, Integer> locationByName) {
        System.out.println(getGameStatus(locationByName));
    }

    private String getGameStatus(Map<String, Integer> locationByName) {
        sb.setLength(0);
        for (Entry<String, Integer> entry : locationByName.entrySet()) {
            String name = entry.getKey();
            String location = getStringOfLocation(entry.getValue());
            sb.append(String.format(FORMAT_OF_GAME_STATUS, name, location))
                .append("\n");
        }
        return sb.toString();
    }

    private String getStringOfLocation(int location) {
        return SYMBOL_OF_STATUS.repeat(location);
    }

    public void printGameWinners(List<String> winnerNames) {
        String joinedWinnerNames = String.join(WINNER_NAME_DELIMITER, winnerNames);
        System.out.printf((FORMAT_OF_WINNERS) + "%n", joinedWinnerNames);
    }

    public void printError(Exception e) {
        System.out.println(DEFAULT_ERROR_MESSAGE + e.getMessage());
    }
}
