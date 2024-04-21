package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.FakeMovableNumberGenerator;
import racingcar.infrastructure.FakeNotMovableNumberGenerator;

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
        assertAll(
                () -> assertThat(movedCars.cars().get(0).getPosition()).isEqualTo(1),
                () -> assertThat(movedCars.cars().get(1).getPosition()).isEqualTo(0),
                () -> assertThat(movedCars.cars().get(2).getPosition()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("우승 자동차들을 찾을 수 있다.")
    void findWinners() {
        // given
        Cars cars = new Cars(List.of(
                new Car("name1", new FakeMovableNumberGenerator()),
                new Car("name2", new FakeNotMovableNumberGenerator()),
                new Car("name3", new FakeMovableNumberGenerator())
        ));

        // when
        Cars movedCars = cars.moveForward();
        Cars winners = movedCars.findWinners();

        // then
        assertAll(
                () -> assertThat(winners.cars().get(0).getName()).isEqualTo("name1"),
                () -> assertThat(winners.cars().get(1).getName()).isEqualTo("name3")
        );
    }

    @Test
    @DisplayName("자동차들에게 NumberGenerator를 주입하여 생성할 수 있다.")
    void createCarsWithGenerator() {
        // given
        Cars cars = Cars.createCarsWithGenerator(List.of("name1", "name2", "name3"), new FakeMovableNumberGenerator());

        // when
        Cars movedCars = cars.moveForward();

        // then
        assertAll(
                () -> assertThat(movedCars.cars().get(0).getPosition()).isEqualTo(1),
                () -> assertThat(movedCars.cars().get(1).getPosition()).isEqualTo(1),
                () -> assertThat(movedCars.cars().get(2).getPosition()).isEqualTo(1)
        );
    }
}
