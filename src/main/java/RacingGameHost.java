import Exceptions.InvalidCarNameLengthException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameHost {

  public static List<String> getCarNames(final Scanner sc) {
    List<String> result = null;
    while (result == null) {
      System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
      String namesText = sc.nextLine();

      try {
        result = Arrays.stream(namesText.split(","))
            .map(String::strip)
            .peek(RacingGameHost::checkNameLength)
            .toList();
      } catch (InvalidCarNameLengthException exception) {
        System.out.println("이름은 5자 이하만 입력 가능합니다.");
      }

    }

    return result;
  }

  private static void checkNameLength(final String name) {
    if (name.length() > 5) {
      throw new InvalidCarNameLengthException();
    }
  }

  public static int getCount(final Scanner sc) {
    System.out.println("시도할 회수는 몇회인가요?");
    return sc.nextInt();
  }

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


  public static void playGame(final RacingGame game) {
    List<Car> cars = game.getCars();

    for (int i = 0; i < game.getRound(); i++) {
      game.proceedGame();
      RacingGameHost.projectCars(cars);
      System.out.println();
    }

  }
}
