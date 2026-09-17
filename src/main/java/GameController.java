import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class GameController {
    private ArrayList<Car> cars;
    private ArrayList<Car> winners;
    private int roundCount;

    public GameController() {
        cars = new ArrayList<>();
    }

    public void run() {
        input();
        playRace();
        printWinners();
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

    private void playRace() {
        System.out.println("실행 결과");
        CarRace carRace = new CarRace(cars, new RandomNumGenerator());
        for (int i = 0; i < roundCount; i++) {
            carRace.moveCars();
            printResult();
        }
        winners = carRace.getWinners();
    }

    private void printResult() {
        for (Car car : cars) {
            car.print();
        }
    }

    private void printWinners() {
        StringJoiner winnerNames = new StringJoiner(", ");
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
