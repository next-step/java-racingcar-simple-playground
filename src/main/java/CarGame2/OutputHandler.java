package CarGame2;

import java.util.List;

public class OutputHandler {

    public void printRoundStart(int round) {
        System.out.println("\nROUND " + round);
    }

    public void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printRoundEnd() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
