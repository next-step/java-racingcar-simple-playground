import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class View {
    private Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(ArrayList<Car> winners) {
        StringJoiner winnerNames = new StringJoiner(", ");
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
