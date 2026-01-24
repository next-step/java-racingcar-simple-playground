package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InputErrorCode;
import racingcar.exception.InvalidInputException;

class CarsTest {

    @DisplayName("자동차 이름 리스트로 자동차를 생성하고 보관한다.")
    @Test
    void createsCarsFromNames() {
        // given
        List<String> names = List.of("A", "B", "C");

        // when
        Cars cars = Cars.from(names);

        // then
        assertAll(
                () -> assertThat(cars.asUnmodifiableList()).hasSize(3),
                () -> assertThat(cars.asUnmodifiableList())
                        .extracting(Car::getName)
                        .containsExactly("A", "B", "C")
        );
    }


    @DisplayName("자동차 이름 리스트가 비어있으면 예외를 발생시킨다.")
    @Test
    void from_throws_whenNamesEmpty() {
        assertThatThrownBy(() -> Cars.from(List.of()))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(InputErrorCode.CAR_NAMES_BAD_FORMAT.message());
    }

    @DisplayName("자동차 이름 리스트가 null이면 예외를 발생시킨다.")
    @Test
    void from_throws_whenNamesNull() {
        assertThatThrownBy(() -> Cars.from(null))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(InputErrorCode.CAR_NAMES_BAD_FORMAT.message());
    }

    @DisplayName("움직일 수 있는 경우에는 전진한다.")
    @Test
    void raceOneRound_moves_whenStrategyAllows() {
        // given
        Cars cars = Cars.from(List.of("A"));
        MoveStrategy alwaysMove = new FixedMoveStrategy(true);

        // when
        cars.raceOneRound(alwaysMove);

        // then
        assertThat(findByName(cars, "A").getPosition()).isEqualTo(1);
    }

    @DisplayName("움직일 수 없는 경우에는 전진하지 않는다.")
    @Test
    void raceOneRound_doesNotMove_whenStrategyDenies() {
        // given
        Cars cars = Cars.from(List.of("A"));
        MoveStrategy neverMove = new FixedMoveStrategy(false);

        // when
        cars.raceOneRound(neverMove);

        // then
        assertThat(findByName(cars, "A").getPosition()).isEqualTo(0);
    }

    @DisplayName("가장 큰 Position을 가진 자동차를 우승자로 선정할 수 있다. - 우승자 한 명")
    @Test
    void winners_oneWinner() {
        // given
        Cars cars = Cars.from(List.of("A", "B", "C"));
        Car carA = findByName(cars, "A");
        Car carB = findByName(cars, "B");
        Car carC = findByName(cars, "C");

        moveForwardTimes(carA, 3);
        moveForwardTimes(carB, 2);
        moveForwardTimes(carC, 1);

        // when
        List<Car> winners = cars.winners();

        // then
        assertAll(
                () -> assertThat(winners).hasSize(1),
                () -> assertThat(winners)
                        .extracting(Car::getName)
                        .containsExactly("A")
        );
    }

    @DisplayName("가장 큰 Position을 가진 자동차를 우승자로 선정할 수 있다. - 우승자 한 명 이상")
    @Test
    void winners_moreThanOneWinners() {
        // given
        Cars cars = Cars.from(List.of("A", "B", "C"));
        Car carA = findByName(cars, "A");
        Car carB = findByName(cars, "B");
        Car carC = findByName(cars, "C");

        moveForwardTimes(carA, 3);
        moveForwardTimes(carB, 2);
        moveForwardTimes(carC, 3);

        // when
        List<Car> winners = cars.winners();

        // then
        assertAll(
                () -> assertThat(winners).hasSize(2),
                () -> assertThat(winners)
                        .extracting(Car::getName)
                        .containsExactlyInAnyOrder("A", "C")
        );
    }

    private void moveForwardTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.moveForward();
        }
    }

    private Car findByName(Cars cars, String name) {
        return cars.asUnmodifiableList().stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
