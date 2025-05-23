import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> carList = inputCar(scanner);
        int time = inputTime(scanner);

        new RacingCars(carList)
                .playRound(time)
                .printWinner();
    }

    public static List<Car> inputCar(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return GenerateCar(input);
    }

    private static List<Car> GenerateCar(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, new RandInt()));
        }
        return cars;
    }

    public static int inputTime(Scanner scanner) {
        System.out.println("경기횟수를 입력하세요");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다");
            throw e;
        }
    }
}
