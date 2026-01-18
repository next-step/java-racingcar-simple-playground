import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 2단계 테스트")
public class CarsTest {

    @Nested
    @DisplayName("이동")
    class MoveAll {

        @Test
        @DisplayName("모든 자동차는 한 라운드에 한 번씩 이동을 시도한다")
        void movesAllCarsOnce() {
            Cars cars = new Cars(List.of(
                    new Car("meow"),
                    new Car("kitty"),
                    new Car("yeongeun")
            ));

            cars.moveAll(new FixedNumberGenerator(4));

            assertThat(cars.asList())
                    .extracting(Car::position)
                    .containsExactly(1, 1, 1);
        }
    }

    @Nested
    @DisplayName("우승자")
    class Winners {

        @Test
        @DisplayName("가장 많이 이동한 자동차 한 명을 우승자로 반환한다")
        void returnsSingleWinner() {
            Car meow = new Car("meow");
            Car yeongeun = new Car("yeongeun");

            meow.move(new FixedNumberGenerator(4));
            meow.move(new FixedNumberGenerator(4));
            yeongeun.move(new FixedNumberGenerator(4));

                    Cars cars = new Cars(List.of(meow, yeongeun));

            assertThat(cars.winnerNames()).containsExactly("meow");
        }

        @Test
        @DisplayName("동점이면 공동 우승자를 모두 반환한다")
        void returnsMultipleWinnersWhenTied() {
            Car meow = new Car("meow");
            Car kitty = new Car("kitty");
            Car yeongeun = new Car("yeongeun");

            meow.move(new FixedNumberGenerator(4));
            kitty.move(new FixedNumberGenerator(4));
            yeongeun.move(new FixedNumberGenerator(3));

            Cars cars = new Cars(List.of(meow, kitty, yeongeun));

            assertThat(cars.winnerNames()).containsExactlyInAnyOrder(
                    "meow", "kitty");
        }
    }
}