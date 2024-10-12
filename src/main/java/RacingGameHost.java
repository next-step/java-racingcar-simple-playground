import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameHost {

  public static void projectWinners(final RacingGame game) {
    List<String> winnerNames = game.getWinnerNames();
    System.out.println(String.join(",", winnerNames) + "가 최종우승했습니다.");
  }

  public static void projectCars(List<Car> cars) {
    cars.forEach((car) -> {
      String progressBar = "-".repeat(car.getCoordinateX());
      System.out.println(car.getName() + " : " + progressBar);
    });
  }

}
