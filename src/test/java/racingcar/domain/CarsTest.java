package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차들에게 전진 명령을 할 수 있다.")
    void moveForward() {
        // given
        Cars cars = new Cars(List.of(
                new Car("name1", new FakeMovableNumberGenerator()),
                new Car("name2", new FakeNotMovableNumberGenerator()),
                new Car("name3", new FakeMovableNumberGenerator())
        ));

        // when
        Cars movedCars = cars.moveForward();

        // then
        assertThat(movedCars.cars())
                .extracting(Car::getPosition)
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("우승 자동차들을 찾을 수 있다.")
    void findWinners() {
        // given
        Cars cars = new Cars(List.of(
                new Car("name1", 1, new FakeMovableNumberGenerator()),
                new Car("name2", 0, new FakeNotMovableNumberGenerator()),
                new Car("name3", 1, new FakeMovableNumberGenerator())
        ));

        // when
        Cars winners = cars.findWinners();

        // then
        assertThat(winners.cars())
                .extracting(Car::getName)
                .containsExactly("name1", "name3");
    }

    @Test
    @DisplayName("자동차들에게 NumberGenerator를 주입하여 생성할 수 있다.")
    void createCarsWithGenerator() {
        // expect
        assertThatCode(() -> Cars.createCarsWithGenerator(
                List.of("name1", "name2", "name3"),
                new FakeMovableNumberGenerator())
        ).doesNotThrowAnyException();
    }
}
