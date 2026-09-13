package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCarWinnerTest {

    @Test
    @DisplayName("우승자 찾기 테스트")
    public void winnerTest() {
        Car a = new Car("A");
        Car b = new Car("B");
        Car c = new Car("C");
        Car d = new Car("D");
        Car e = new Car("E");

        Cars cars = new Cars(List.of(a, b, c, d, e));

        cars.carRace(new RandomNumber(), 5);

        List<Car> winners = cars.findWinner();

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
