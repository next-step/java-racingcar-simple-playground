import java.util.List;

public class OutputView {

    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public void printRound(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerCars){
        System.out.printf("최종 우승자 : %s%n", String.join(", ", winnerCars));
    }
}
