package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("경주 후 우승자는 1명 혹은 그 이상을 수 있다.")
    @MethodSource("carsAndWinners")
    @ParameterizedTest
    void get_winners(Cars cars, List<Car> expect) {
        // given
        final int count = 5;
        final RacingGame racingGame = new RacingGame(cars, new RacingCount(count));

        // when
        racingGame.moveCars();
        final List<Car> result = racingGame.getWinners();

        // then

        assertThat(result).usingRecursiveComparison()
                .isEqualTo(expect);
    }

    private static Stream<Arguments> carsAndWinners() {
        final Car moveCar1 = new Car("자동차1", new AlwaysMoveStrategy());
        final Car moveCar2 = new Car("자동차2", new AlwaysMoveStrategy());
        final Car moveCar3 = new Car("자동차3", new AlwaysMoveStrategy());
        final Car notMoveCar = new Car("자동차4", new AlwaysNotMoveStrategy());

        return Stream.of(
                Arguments.of(new Cars(List.of(moveCar1, moveCar2, notMoveCar)), List.of(moveCar1, moveCar2)),
                Arguments.of(new Cars(List.of(moveCar3, notMoveCar)), List.of(moveCar3))
        );
    }
}
