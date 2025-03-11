import java.util.ArrayList;
import java.util.List;

public class CarRunner {
  public static void main(String[] args) throws Exception {
    List<Car> cars=RaceInput.getCars();
    int attempts=RaceInput.getAttempts();

    runRace(cars,attempts);
  }

  private static void runRace(List<Car> cars, int attempts)  {
    for (int round = 1; round <= attempts; round++) {
      List<Integer> speeds = moveAllCars(cars);
      printRound(cars, speeds, round);
    }
    printResult(cars);
  }

  private static List<Integer> moveAllCars(List<Car> cars) {
    List<Integer> speeds = new ArrayList<>();
    for (Car car : cars) {
      speeds.add(car.move());
    }
    return speeds;
  }

  private static void printRound(List<Car> cars, List<Integer> speeds, int round) {
    System.out.println("-------------" + round + "라운드--------------");
    printMoves(cars, speeds);
    printAllPositions(cars);
    System.out.println();
  }

  private static void printMoves(List<Car> cars, List<Integer> speeds) {
    for (int i = 0; i < cars.size(); i++) {
      printOneMove(cars.get(i).getIndex(), speeds.get(i));
    }
  }

  private static void printOneMove(int carIndex, int speed) {
    if (speed >= 4) {
      System.out.println(carIndex + "번 차량이 " + speed + "만큼 전진했습니다.");
      return;
    }
    System.out.println(carIndex + "번 차량은 전진하지 않았습니다.");
  }

  private static void printAllPositions(List<Car> cars) {
    for (Car car : cars) {
      System.out.println("-".repeat(car.getPosition()) + " (" + car.getPosition() + ")");
    }
  }

  private static void printResult(List<Car> cars) {
    WinnerFinder finder = new WinnerFinder();
    List<Integer> winners = finder.findWinners(cars);
    System.out.println("-------------최종 결과--------------");
    printAllPositions(cars);
    System.out.print("우승자: "+winners);
  }

}