import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Nested
    @DisplayName("모든 자동차 이동")
    class MoveAll {

        @Test
        @DisplayName("모든 자동차는 한 라운드에 한 번씩 이동을 시도한다")
        void movesAllCarsOnce() {
            Cars cars = new Cars(List.of(
                    new Car("meow"),
                    new Car("kitty"),
                    new Car("aa")
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
            Car aa = new Car("aa");

            meow.move(new FixedNumberGenerator(4));
            meow.move(new FixedNumberGenerator(4));
            aa.move(new FixedNumberGenerator(4));

                    Cars cars = new Cars(List.of(meow, aa));

            assertThat(cars.winnerNames()).containsExactly("meow");
        }

        @Test
        @DisplayName("동점이면 공동 우승자를 모두 반환한다")
        void returnsMultipleWinnersWhenTied() {
            Car meow = new Car("meow");
            Car kitty = new Car("kitty");
            Car aa = new Car("aa");

            meow.move(new FixedNumberGenerator(4));
            kitty.move(new FixedNumberGenerator(4));
            aa.move(new FixedNumberGenerator(3));

            Cars cars = new Cars(List.of(meow, kitty, aa));

            assertThat(cars.winnerNames()).containsExactlyInAnyOrder(
                    "meow", "kitty");
        }
    }
}
