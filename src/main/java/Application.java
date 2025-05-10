import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String[] racingCarName = scanner.nextLine().split(",");

        if (racingCarName.length > 5) {
            System.out.println("자동차는 최대 5대까지만 입력할 수 있습니다.");
            return;
        }

        Optional<String> invalidName = Arrays.stream(racingCarName)
                .map(String::trim)
                .filter(name -> name.length() > 5)
                .findFirst();

        if (invalidName.isPresent()) {
            System.out.println("자동차 이름은 5자 이하여야 합니다: " + invalidName.get());
            return;
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int testRound = Integer.parseInt(scanner.nextLine());

        RacingCar[] racingCar = new RacingCar[racingCarName.length];
        for (int i = 0; i < racingCarName.length; i++) {
            racingCar[i] = new RacingCar(racingCarName[i].trim(), new RandomNumber());
        }

        RacingGame racingGame = new RacingGame(racingCar);
        racingGame.runRace(testRound);

        System.out.println("==============실행결과============");
        for (RacingCar racingCars : racingCar) {
            System.out.println(racingCars.getCarName().repeat(racingCars.getPosition()));
        }

        System.out.println("우승 자동차:" + String.join(",", racingGame.getWinnerName()));

    }
}
