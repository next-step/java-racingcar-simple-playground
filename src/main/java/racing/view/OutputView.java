package racing.view;
import racing.domain.Car;
import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinners(List<String> winnerNames) {
        if (winnerNames == null || winnerNames.isEmpty()) {
            return;
        }
        String result = String.join(", ", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }


    public static void println(){
        System.out.println();
    }

}
