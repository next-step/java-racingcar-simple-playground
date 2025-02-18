package view;

import domain.Racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void printMoving(Racing race) {
        List<List<Integer>> rounds = race.getMoveData();
        List<String> carNames = race.getCarsName();
        System.out.println("\n실행 결과");
        rounds.stream()
                .forEach(round -> {
                    IntStream.range(0, round.size())
                            .forEach(i -> System.out.println(
                                    carNames.get(i) + " : " + "-".repeat(round.get(i))
                            ));
                    System.out.println();
                });
    }



    public static void printWinners(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
