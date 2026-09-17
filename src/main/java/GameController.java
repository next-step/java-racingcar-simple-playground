import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    // 입력받기
    // 경주하기
    // 출력하기
    private ArrayList<Car> cars;
    private ArrayList<Car> winners;
    private int roundCount;

    public GameController() {
    }

    public void run() {
        input();

        CarRace carRace = new CarRace(cars, roundCount, new RandomNumGenerator());
        carRace.race();
        winners = carRace.getWinners();


    }

    private void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        addCars(value);

        System.out.println("시도할 회수는 몇회인가요?");
        roundCount = scanner.nextInt();
    }

    private void addCars(String value) {
        String[] names = value.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
