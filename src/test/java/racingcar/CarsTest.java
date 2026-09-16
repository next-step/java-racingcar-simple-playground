package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자다")
    void returnsSingleWinnerWhenOneCarLeads() {
        Car a = new Car("A");
        Car b = new Car("B");
        a.moveIfPossible(4);
        a.moveIfPossible(5);
        b.moveIfPossible(4);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactly(a);
    }

    @Test
    @DisplayName("공동 우승자가 있을 수 있다")
    void returnsMultipleWinnersWhenTied() {
        Car a = new Car("A");
        Car b = new Car("B");
        a.moveIfPossible(4);
        b.moveIfPossible(4);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactlyInAnyOrder(a, b);
    }

}
