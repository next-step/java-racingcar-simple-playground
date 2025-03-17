import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceInput {

  private final Scanner scanner;

  public RaceInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public Cars inputCars() {
    int carCount = getCarCount();
    scanner.nextLine();
    List<String> carNames = new ArrayList<>();
    for (int i = 1; i <= carCount; i++) {
      carNames.add(getCarName(i));
    }
    return new Cars(carNames);
  }

  public int getCarCount() {
    System.out.print("자동차 대수를 입력하세요 (2대 이상): ");
    int carCount = scanner.nextInt();
    Cars.validateCarCount(carCount);
    return carCount;
  }

  public int getAttempts() {
    System.out.print("시도 횟수를 입력하세요 (1회 이상): ");
    int attempts = scanner.nextInt();
    Cars.validateAttempts(attempts);
    return attempts;
  }

  public String getCarName(int index) {
    System.out.print(index + "번째 차량 이름을 입력하세요: ");
    return scanner.nextLine();
  }
}
