package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Nested
    @DisplayName("우승자 판별 기능")
    class WinnerTests {

        @Test
        @DisplayName("가장 멀리 간 자동차 한 대를 우승자로 반환한다")
        void findSingleWinner() {
            Car winner = new Car(new Name("위너"));
            winner.move(new MoveCondition(() -> 5));

            Car loser = new Car(new Name("Loser"));

            Cars cars = new Cars(List.of(winner, loser));

            List<Car> winners = cars.findWinners();
            assertThat(winners).containsExactly(winner);
        }

        @Test
        @DisplayName("가장 멀리 간 자동차가 여러 대면 모두 우승자로 반환한다")
        void findMultipleWinners() {
            Car a = new Car(new Name("A"));
            Car b = new Car(new Name("B"));
            Car c = new Car(new Name("C"));

            MoveCondition move = new MoveCondition(() -> 6);
            a.move(move);
            b.move(move);

            Cars cars = new Cars(List.of(a, b, c));
            List<Car> winners = cars.findWinners();

            assertThat(winners).containsExactlyInAnyOrder(a, b);
        }
    }
}
