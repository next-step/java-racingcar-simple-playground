package view;

import domain.Car;
import java.util.List;

public class ResultView {

  public void printStart() {
    System.out.println("\n실행 결과");
  }

  public void printRound(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
    System.out.println();
  }

  public void printWinners(List<String> winners) {
    System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
  }
}
