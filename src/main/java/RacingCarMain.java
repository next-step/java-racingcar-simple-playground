import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class RacingCarMain {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = scanner.nextLine();
        String[] names = carNamesInput.split(",");

        RacingCar[] cars = new RacingCar[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new RacingCar(names[i].trim());
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = scanner.nextInt();

        System.out.println("실행결과");
        for (int i = 0; i < attemptCount; i++) {
            for (RacingCar car: cars){
                car.move();
            }

            for (RacingCar car : cars){
                System.out.println(car);
            }
        }
        List<RacingCar> winners = RacingCar.findWinners(Arrays.asList(cars));

        System.out.println("\n 우승한 자동차: ");
        System.out.println(String.join("," , winners.stream().map(RacingCar::getName).toList()));
    }
}

