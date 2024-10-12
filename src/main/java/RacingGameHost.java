import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameHost {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String nameInput = sc.nextLine();
    System.out.println("시도할 회수는 몇회인가요?");
    int count = sc.nextInt();

    RacingGame game = new RacingGame();
    List<String> names = Arrays.stream(nameInput.split(","))
        .map(String::strip)
        .toList();

    for (String name : names) {
      game.addCar(new Car(new RandomNumberGenerator(), 0, name));
    }

    List<Car> cars = game.getCars();
    for (int i = 0; i < count; i++) {
      game.proceedGame();
      projectCars(cars);
      System.out.println();
    }

    projectWinners(game);
  }

  private static void projectWinners(final RacingGame game) {
    List<String> winnerNames = game.getWinnerNames();
    System.out.println(String.join(",", winnerNames) + "가 최종우승했습니다.");
  }

  private static void projectCars(List<Car> cars) {
    cars.forEach((car) -> {
      String progressBar = "-".repeat(car.getCoordinateX());
      System.out.println(car.getName() + " : " + progressBar);
    });
  }

}
