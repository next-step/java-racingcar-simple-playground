import domain.Car;
import domain.Cars;
import domain.Race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("domain.Race 2단계 테스트")
public class RaceTest {

    @Nested
    @DisplayName("게임 진행")
    class Run {

        @Test
        @DisplayName("주어진 횟수만큼 모든 자동차가 이동을 수행한다")
        void runsForTryCount() {
            Cars cars = new Cars(List.of(
                    new Car("meow"),
                    new Car("kitty")
            ));
            Race race = new Race(cars);

            race.run(3, new FixedNumberGenerator(4));

            assertThat(race.cars().asList())
                    .extracting(Car::position)
                    .containsExactly(3, 3);
        }
    }
}