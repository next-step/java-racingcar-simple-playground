import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("단어를 입력하세요");
        }

        String[] names = input.split(",");
        System.out.println("시도할 횟수는 몇 회인가요?");
        int times = 0;

        try {
            times = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, new RandInt()));
        }

        RacingCars game = new RacingCars(cars);
        game.playRound(times)
                .printWinner();
    }

}
