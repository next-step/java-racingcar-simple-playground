import java.util.List;

public class OutputView {
    public void printRound(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getName() + ":" + "-".repeat(car.getPosition()));
        }
    }

    public void printWinner(List<String> winners) {
        String joinWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + joinWinners);
    }
}
