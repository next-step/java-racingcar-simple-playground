import decider.RandomPositionDecider;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingApp {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        final Scanner scanner = new Scanner(System.in);
        final String nameInput = scanner.nextLine();

        final String[] names = nameInput.split(",");
        if (Arrays.stream(names).anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        final int times = scanner.nextInt();

        final List<Car> cars = Arrays.stream(names)
            .map(name -> new Car(name, new RandomPositionDecider()))
            .toList();

        final Racing racing = new Racing(times, cars);

        System.out.println("실행 결과");
        racing.start();

        final List<Car> winners = racing.getWinners();
        final String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
