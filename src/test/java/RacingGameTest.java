import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Nested
    @DisplayName("게임 진행 테스트")
    class RunTests {

        @Test
        @DisplayName("3번 라운드 실행 시 자동차는 최대 3칸까지 이동할 수 있다")
        void carMovesUpToThreeTimes() {
            Cars cars = new Cars(List.of(
                    new Car(new Name("A")),
                    new Car(new Name("B"))
            ));
            MoveCondition alwaysMove = new MoveCondition(() -> 9);
            RacingGame game = new RacingGame(cars, alwaysMove);

            game.run(3);

            assertThat(cars.getCars())
                    .extracting(Car::getPosition)
                    .containsExactly(3, 3);
        }

        @Test
        @DisplayName("0번 라운드 실행 시 자동차는 이동하지 않는다")
        void carDoesNotMoveWhenZeroRounds() {
            Cars cars = new Cars(List.of(
                    new Car(new Name("A")),
                    new Car(new Name("B"))
            ));
            MoveCondition alwaysMove = new MoveCondition(() -> 9);
            RacingGame game = new RacingGame(cars, alwaysMove);

            game.run(0);

            assertThat(cars.getCars())
                    .extracting(Car::getPosition)
                    .containsExactly(0, 0);
        }
    }

    @Nested
    @DisplayName("우승자 판별 테스트")
    class WinnerTests {

        @Test
        @DisplayName("가장 멀리 간 자동차가 우승자다")
        void returnsWinnerAfterRace() {
            Car a = new Car(new Name("A"));
            Car b = new Car(new Name("B"));
            Cars cars = new Cars(List.of(a, b));

            List<Integer> values = List.of(5, 2, 2, 2);
            Iterator<Integer> iterator = values.iterator();

            MoveCondition moveOnlyA = new MoveCondition(iterator::next);

            RacingGame game = new RacingGame(cars, moveOnlyA);
            game.run(2);

            List<Car> winners = game.getWinners();
            assertThat(winners).containsExactly(a);
        }


        @Test
        @DisplayName("동일한 위치의 자동차가 여러 대면 모두 우승자다")
        void multipleWinnersWhenSameMaxPosition() {
            Car a = new Car(new Name("A"));
            Car b = new Car(new Name("B"));
            Cars cars = new Cars(List.of(a, b));

            MoveCondition alwaysMove = new MoveCondition(() -> 8);
            RacingGame game = new RacingGame(cars, alwaysMove);
            game.run(2);

            List<Car> winners = game.getWinners();
            assertThat(winners).containsExactlyInAnyOrder(a, b);
        }
    }
}
