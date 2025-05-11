import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        List<String> racingCarName = Arrays.stream(scanner.nextLine().split(","))
                .map(String::strip)
                .collect(Collectors.toList());


        racingCarName.stream()
                .map(String::strip)
                .forEach(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("자동차의 이름은 5자 이하로 작성해주세요" + name);
                    }
                });

        System.out.println("시도할 회수는 몇회인가요?");
        int testRound = Integer.parseInt(scanner.nextLine());

        List<RacingCar> racingCar = racingCarName.stream()
                .map(name -> new RacingCar(name, new RandomNumber()))
                .collect(Collectors.toList());

        RacingGame racingGame = new RacingGame(racingCar);
        racingGame.runRace(testRound);

        System.out.println("==============실행결과============");
        for (RacingCar racingCars : racingCar) {
            System.out.println(racingCars.getCarName().repeat(racingCars.getPosition()));
        }

        System.out.println("우승 자동차:" + String.join(",", racingGame.getWinnerName()));

    }
}
