import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.");

        String input = scanner.nextLine();

        String[] names = input.split(",");

        System.out.println("시도할 회수는 몇 회인가요?");

        int times = scanner.nextInt();

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, new RandInt()));
        }//배열을 사용하게 되면 for문을 두 번 써야해서 리스트로 저장후 배열로 변환을 했는데 다른 방법?

        Car[] carsArray = cars.toArray(new Car[0]);

        RacingCars game = new RacingCars(carsArray);

        game.playRound(times);
        game.getWinner();
        game.printWinner();
    }

}
