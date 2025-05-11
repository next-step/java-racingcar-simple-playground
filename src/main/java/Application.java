import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        List<String> racingCarName = Arrays.stream(scanner.nextLine().split(","))
                .map(String::strip)
                .collect(Collectors.toList());

        RacingCarCheck.checkCarName(racingCarName);


        System.out.println("시도할 회수는 몇회인가요?");
        int testRound = Integer.parseInt(scanner.nextLine());

        List<RacingCar> racingCar = racingCarName.stream()
                .map(name -> new RacingCar(name, new RandomNumber()))
                .collect(Collectors.toList());

        RacingGame racingGame = new RacingGame(racingCar);

        System.out.println("실행결과");

        for (int i = 0; i < testRound; i++) {
            for (RacingCar car : racingCar) {
                int randomNum = RandomNumber.generate();
                car.move(randomNum);
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        List<String> winners = racingGame.getWinnerName();
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");



    }

}


