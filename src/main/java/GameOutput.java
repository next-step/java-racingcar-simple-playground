import java.util.List;

public class GameOutput {

    public static void printStart() {
        System.out.println("\n실행 결과");
    }
    public static void printRound(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
