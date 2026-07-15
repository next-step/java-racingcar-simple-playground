import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = createCars(scanner);
        RacingGame racingGame = new RacingGame(cars);
        runRace(racingGame, cars, tryCount(scanner));
    }

    private static List<Car> createCars(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int tryCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private static void runRace(RacingGame racingGame, List<Car> cars, int tryCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int count = 0; count < tryCount; count++) {
            racingGame.moveCars();
            printCars(cars);
        }
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + createPosition(car.getLocation()));
    }

    private static String createPosition(int location) {
        StringBuilder carLocation = new StringBuilder();
        for (int count = 0; count < location; count++) {
            carLocation.append("-");
        }
        return carLocation.toString();
    }
}
