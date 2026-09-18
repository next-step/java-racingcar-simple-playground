import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = readCars(scanner);
        int rounds = readRounds(scanner);

    }


    private static List<Car> readCars(Scanner scanner){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",", -1);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static int readRounds(Scanner scanner){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

}
