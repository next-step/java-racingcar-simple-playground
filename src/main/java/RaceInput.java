import java.util.Scanner;

public class RaceInput {

  private final static Scanner scanner = new Scanner(System.in);

  public static void inputCars(CarFactory carFactory) {
    int carCount = getCarCount();
    scanner.nextLine();
    for (int i = 1; i <= carCount; i++) {
      String name = getCarName(i);
      carFactory.addCar(name);
    }

  }

  private static int getCarCount() {
    System.out.print("자동차 대수를 입력하세요: ");
    return scanner.nextInt();
  }

  public static int getAttempts() {
    System.out.print("시도 횟수를 입력하세요: ");
    return scanner.nextInt();
  }

  private static String getCarName(int index) {
    System.out.print(index + "번째 차량 이름을 입력하세요: ");
    return scanner.nextLine();
  }
}
