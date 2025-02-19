package view;

import java.util.List;
import java.util.Map;

public class RaceOutputView {

    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void inputRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRacingData(List<Map<String, Integer>> moveData) {
        System.out.println("\n실행 결과");
        for (Map<String, Integer> data : moveData) {
            data.forEach(
                    (key, value) ->
                            System.out.println(key + " : " + "-".repeat(value))
            );
            System.out.println();
        }
    }

    public void printWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
