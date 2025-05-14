import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();
        List<String> carNames = Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = scanner.nextInt();

        RacingGame game = new RacingGame(carNames,new RandomNumberProvider(), rounds);
        System.out.println("\n실행 결과");
        game.play(rounds);

        List<Car> winners = game.getWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
