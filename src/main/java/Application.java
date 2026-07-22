import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        
        System.out.println("시도할 회수는 몇회인가요?");
        int round = scanner.nextInt();
        System.out.println();

        for (String name : carNames.split(",")) {
            cars.add(new Car(name.trim()));
        }

        RacingGame racingGame = new RacingGame(cars);

        runGame(round, racingGame, cars);

        scanner.close();
    }

    public static void runGame(int round, RacingGame racingGame, List<Car> cars) {
        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            printRoundResult(cars);
            System.out.println();
        }

        printWinners(racingGame);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
    }

    public static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public static void printWinners(RacingGame racingGame) {
        StringJoiner winnerNames = new StringJoiner(", ");
        List<Car> winners = racingGame.findWinners();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}