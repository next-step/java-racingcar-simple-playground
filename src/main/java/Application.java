import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = readCars(scanner);
        int rounds = readValidRounds(scanner);

        RacingGame game = new RacingGame(cars, new RandomNumberGenerator());
        System.out.println("\n실행결과");
        runRace(game, cars, rounds);
        System.out.println(String.join(", ", game.getWinners()) + "가 최종 우승했습니다.");
    }


    private static List<Car> readCars(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",", -1);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }


    private static int readValidRounds(Scanner scanner) {
        Integer rounds = null;
        while (rounds == null) {
            rounds = tryReadRounds(scanner);
        }
        return rounds;
    }

    private static Integer tryReadRounds(Scanner scanner) {
        try {
            return readRounds(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("0 이상의 정수를 입력해주세요.");
            return null;
        }
    }

    private static int readRounds(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(scanner.nextLine());
        if (rounds < 0) {
            throw new IllegalArgumentException("횟수는 음수일 수 없습니다.");
        }
        return rounds;
    }

    private static void runRace(RacingGame game, List<Car> cars, int rounds) {
        for (int round = 0; round < rounds; round++) {
            game.race(1);
            printCars(cars);
        }
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
