package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCarWinnerTest {

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자다")
    void findWinnerTest() {
        Car a = new Car("A");
        Car b = new Car("B");
        a.movePoint(4);
        a.movePoint(5);
        b.movePoint(4);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactly(a);
    }

    @Test
    @DisplayName("공동 우승자가 있을 수 있다")
    void findWinnerTests() {
        Car a = new Car("A");
        Car b = new Car("B");
        a.movePoint(4);
        b.movePoint(4);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactlyInAnyOrder(a, b);
    }


}
