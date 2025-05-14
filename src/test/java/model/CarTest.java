package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.AlwaysFalseMoveStrategy;
import strategy.AlwaysTrueMoveStrategy;

class CarTest {

    @Test
    @DisplayName("자동차는 정상적으로 이름을 갖는다.")
    void shouldReturnNameForCar() {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();
        Car car = new Car("dd", alwaysTrueMoveStrategy);

        // when & then
        assertThat(car.getName()).isEqualTo("dd");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름에 빈 값이 입력될 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyName(String name) {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when & then
        assertThatThrownBy(() -> new Car(name, alwaysTrueMoveStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jiyun", "spider"})
    @DisplayName("자동차 이름이 주어진 최대 이름 길이를 준수하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenMaxNameLength(String name) {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when & then
        assertThatThrownBy(() -> new Car(name, alwaysTrueMoveStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 최대 이름 길이에 맞게 입력해주세요.");
    }

    @Test
    @DisplayName("자동차는 움직이기 위한 최소 힘 이상을 전달한 경우 전진한다.")
    void shouldMoveForward_whenMovableValue() {
        // given
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();
        Car car = new Car("dd", alwaysTrueMoveStrategy);

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 움직이기 위한 최소 힘 미만을 전달할 경우 움직이지 않는다.")
    void shouldStop_whenImmovableValue() {
        // given
        AlwaysFalseMoveStrategy alwaysFalseMoveStrategy = new AlwaysFalseMoveStrategy();
        Car car = new Car("dd", alwaysFalseMoveStrategy);

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
