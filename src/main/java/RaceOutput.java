import java.util.List;

public class RaceOutput {

  public static void printRound(List<Car> cars, int round) {
    System.out.println("-------------" + round + "라운드--------------");
    printMoves(cars);
    printAllPositions(cars);
    System.out.println();
  }

  private static void printMoves(List<Car> cars) {
    for (Car car : cars) {
      printOneMove(car);
    }
  }

  private static void printOneMove(Car car) {
    int speed = car.getLastSpeed();
    if (speed >= 4) {
      System.out.println(car.getName() + " 차량이 " + speed + "만큼 전진했습니다.");
      return;
    }
    System.out.println(car.getName() + " 차량은 전진하지 않았습니다.");
  }

  private static void printAllPositions(List<Car> cars) {
    for (Car car : cars) {
      System.out.println("-".repeat(car.getPosition()) + " (" + car.getPosition() + ")");
    }
  }

  public static void printResult(List<Car> cars) {
    WinnerFinder finder = new WinnerFinder();
    List<String> winners = finder.findWinners(cars);
    System.out.println("-------------최종 결과--------------");
    printAllPositions(cars);
    System.out.print("우승자: " + winners);
  }
}
