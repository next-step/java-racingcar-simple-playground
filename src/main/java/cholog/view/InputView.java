package view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private static final Scanner sc = new Scanner(System.in);

  public static List<String> getPlayerNames() throws Exception {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    var playerNames = Arrays.asList(sc.nextLine().split(","));
    if (playerNames.isEmpty()) {
      throw new Exception("자동차 이름이 입력되지 않았습니다.");
    }
    if (playerNames.size() < 2) {
      throw new Exception("2개 이상의 자동차 이름이 입력되지 않았습니다.");
    }
    return playerNames;
  }

  public static int getRounds() throws Exception {
    System.out.println("시도할 회수는 몇회인가요?");
    var rounds = Integer.parseInt(sc.nextLine());
    if (rounds <= 0) {
      throw new IOException();
    }
    return rounds;
  }
}
