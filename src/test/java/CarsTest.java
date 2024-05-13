import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 자동차를 움직인다.")
    @Test
    void move_all_car() {
        // given
        final Cars cars = new Cars(List.of(new Car("움직이는 자동차", new AlwaysMoveStrategy()), new Car("안움직이는 자동차", new AlwaysNotMoveStrategy())));

        // when
        cars.move();

        // then
        final List<Car> result = cars.getCars();
        assertThat(result.get(0).getPosition()).isEqualTo(1);
        assertThat(result.get(1).getPosition()).isEqualTo(0);
    }

    @DisplayName("경주 후 우승자는 1명 혹은 그 이상을 수 있다.")
    @MethodSource("carsAndWinners")
    @ParameterizedTest
    void get_winners(Cars cars, List<Car> expect) {
        // given
        // when
        cars.move();
        final int maxPosition = cars.getMaxPosition();
        final List<Car> result = cars.getMaxMoveCars(maxPosition);

        // then

        assertThat(result).usingRecursiveComparison()
                .isEqualTo(expect);
    }

    private static Stream<Arguments> carsAndWinners() {
        final Car moveCar1 = new Car("움직이는 자동차1", new AlwaysMoveStrategy());
        final Car moveCar2 = new Car("움직이는 자동차2", new AlwaysMoveStrategy());
        final Car moveCar3 = new Car("움직이는 자동차3", new AlwaysMoveStrategy());
        final Car notMoveCar = new Car("안 움직이는 자동차1", new AlwaysNotMoveStrategy());

        return Stream.of(
                Arguments.of(new Cars(List.of(moveCar1, moveCar2, notMoveCar)), List.of(moveCar1, moveCar2)),
                Arguments.of(new Cars(List.of(moveCar3, notMoveCar)), List.of(moveCar3))
        );
    }
}
