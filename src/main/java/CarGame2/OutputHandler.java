package CarGame2;

import java.util.List;

public class OutputHandler {

    public void printRoundStart(int round) {
        System.out.println("ROUND " + round);
    }

    public void printCarStatus(Car car) {
        System.out.println(car.getName() + " 이동거리: " + car.getSpeed() + " [현재 위치: " + car.getPosition() + "]");
    }

    public void printRoundEnd() {
        System.out.println("-------------------");
    }

    public void printWinners(List<String> winners) {
        System.out.println("우승한 자동차: " + String.join(", ", winners));
    }
}
