package view;

import domain.RacingContest;
import java.util.List;
import java.util.Map;

public class ResultView {

  private static void printRound(Map<String, Integer> distances) {
    if (distances.isEmpty()) {
      throw new IllegalArgumentException();
    }
    StringBuilder sb = new StringBuilder();

    for (Map.Entry<String, Integer> player : distances.entrySet()) {
      sb.append(player.getKey()).append(" : ");
      sb.append("-".repeat(player.getValue())).append("\n");
    }

    System.out.println(sb);
  }

  public static void printWinners(List<String> winners) {
    if (winners.isEmpty()) {
      throw new IllegalArgumentException();
    }
    System.out.print(String.join(", ", winners));
    System.out.println("가 최종 우승했습니다.");
  }

  public static void printContest(RacingContest contest) {
    if (contest == null) {
      throw new IllegalArgumentException();
    }
    int rounds = contest.getRounds();

    System.out.println("\n실행 결과");
    for (int r = 0; r < rounds; r++){
      contest.goRound();
      printRound(contest.getDistances());
    }
    printWinners(contest.getWinners());
  }
}
