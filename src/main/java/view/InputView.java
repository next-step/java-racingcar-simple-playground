package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public List<String> inputCars() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String carNameLine = scanner.nextLine();
    return splicCarNames(carNameLine);
  }

  private List<String> splicCarNames(String carNameLine) {
    return Arrays.asList(carNameLine.split(","));
  }

  public int getAttempts() {
    System.out.println("시도할 회수는 몇회인가요?");
    int attempts = scanner.nextInt();
    return attempts;
  }
}
