import java.util.List;

public class Output {
    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printStatus(Cars cars) {
        cars.getCars().forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
        System.out.println();
    }

    public static void printWinners(List<String> names) {
        System.out.print(String.join(", ", names));
        System.out.println("가 최종 우승했습니다.");
    }
}
