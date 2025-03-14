import java.util.Scanner;

public class RaceInput {

  private final Scanner scanner;

  public RaceInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public void inputCars(CarFactory carFactory) {
    int carCount = getCarCount();
    scanner.nextLine();
    for (int i = 1; i <= carCount; i++) {
      String name = getCarName(i);
      carFactory.addCar(name);
    }

  }

  public int getCarCount() {
    System.out.print("자동차 대수를 입력하세요 (2대 이상): ");
    int carCount = scanner.nextInt();

    if (carCount < 2) {
      throw new IllegalArgumentException("자동차 대수는 2 이상이어야 합니다.");
    }

    return carCount;
  }

  public int getAttempts() {
    System.out.print("시도 횟수를 입력하세요 (1회 이상): ");
    int attempts = scanner.nextInt();

    if (attempts < 1) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }

    return attempts;
  }

  public String getCarName(int index) {
    System.out.print(index + "번째 차량 이름을 입력하세요: ");
    return scanner.nextLine();
  }
}
