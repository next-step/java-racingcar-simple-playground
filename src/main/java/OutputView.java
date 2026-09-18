import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printRound(List<Car> cars){
        System.out.print("실행 결과\n");

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }

        System.out.println("\n");
    }

    public void printWinner(List<Car> winners) {
        List<String> names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String joinWinners = String.join(", ", names);
        System.out.println(joinWinners + "가 최종 우승했습니다.");
    }
}
