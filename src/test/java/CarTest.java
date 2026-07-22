import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CarTest {
    @Test
    @DisplayName("자동차 경주")
    void movesWhenNumberIsFourOrMore() {

        List<Car> cars = new ArrayList<>();

        String input = "neo,brie,brown\n5\n";
        Scanner scanner = new Scanner(input);
        String[] carNames = scanner.nextLine().split(",");
        int number = scanner.nextInt();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        FindWinner winnerFinder = new FindWinner(cars);
        winnerFinder.startRacing(number);
        winnerFinder.FindLongestPosition();
        List<String> winnerNames = winnerFinder.FindWinnerName();

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}