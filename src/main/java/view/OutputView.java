package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String CAR_NAME_DISTANCE_PRINT_FORMAT = "%s : %s\n";
    public static final String WINNER_PRINT_FORMAT ="%s가 최종 우승했습니다.";
    public static final String WINNER_NAME_SEPARATOR= ", ";

    public void printCurrentRaceState(Map<String, List<Integer>> currentRaceState) {
        for (String name : currentRaceState.keySet()) {
            List<Integer> allDistances = currentRaceState.get(name);

            allDistances.forEach((distance) ->{
                System.out.printf(CAR_NAME_DISTANCE_PRINT_FORMAT, name, getDistanceString(distance));
            });
        }

        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnersWithCommas = String.join(WINNER_NAME_SEPARATOR, winners);
        System.out.printf(WINNER_PRINT_FORMAT, winnersWithCommas);
    }

    private String getDistanceString(int n) {
        StringBuilder result = new StringBuilder();

        while (n-->0){
            result.append("-");
        }

        return result.toString();
    }
}
