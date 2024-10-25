import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분): ");
    String carNames = scanner.nextLine();
     while (Arrays.stream(carNames.split(","))
        .anyMatch(s -> s.length() >= 6))
     {
       System.out.println("이름은 5자 이하만 가능합니다.");
       carNames = scanner.nextLine();
     }

    System.out.println("시도할 회수는 몇회인가요?");
    int roundNum = scanner.nextInt();

    final CarRace carRace = new CarRace(roundNum, carNames);
    carRace.runRace();

    List<String> winners = carRace.getCoWinners();
    String result = String.join(", ", winners);
    System.out.println(result + "가 최종 우승했습니다.");

  }

}
