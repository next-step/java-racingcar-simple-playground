import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private final Scanner scanner = new Scanner(System.in);
    private Race race;
    private int rounds;

    public void inputView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Car> cars = Arrays.stream(scanner.nextLine().split(","))
                .map(Car::new)
                .toList();
        this.race = new Race(cars);
        System.out.println("시도할 회수는 몇회인가요?");
        this.rounds = Integer.parseInt(scanner.nextLine());
    }

    public void resultView() {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < rounds; i++) {
            race.playRound();
            printCars();
        }

        String winners = race.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private void printCars() {
        for (Car car : race.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
