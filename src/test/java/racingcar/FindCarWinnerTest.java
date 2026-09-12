package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FindCarWinnerTest {

    @Test
    @DisplayName("우승자 찾기 테스트")
    public void WinnerTest() {
        Car A = new Car("A");
        Car B = new Car("B");
        Car C = new Car("C");
        Car D = new Car("D");
        Car E = new Car("E");

        Cars cars = new Cars(List.of(A, B, C, D, E));


        new CarMove().carRace(cars, new RandomNumber(), 5);

        FindCarWinner findCarWinner = new FindCarWinner();
        List<Car> winners = findCarWinner.findWinner(cars);

        if (winners.isEmpty()) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        assertThat(winners).isNotEmpty();
        System.out.print("우승자: ");
        assertThat(winners).allMatch(car -> car.getCarPosition() == winners.get(0).getCarPosition());

        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            System.out.print(winner.getCarName() + " ");
        }
        System.out.println();
    }

}
