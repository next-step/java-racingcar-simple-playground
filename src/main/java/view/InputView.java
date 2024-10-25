package view;

import domain.CarRace;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
  static Scanner scanner = new Scanner(System.in);

  public static String getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분): ");
    String carNames = scanner.nextLine();
    while (Arrays.stream(carNames.split(","))
        .anyMatch(s -> s.length() >= 6))
    {
      System.out.println("이름은 5자 이하만 가능합니다.");
      carNames = scanner.nextLine();
    }
    return carNames;
  }

  public static int getTryCount() {
    System.out.println("시도할 회수는 몇회인가요?");
    return scanner.nextInt();
  }
}
