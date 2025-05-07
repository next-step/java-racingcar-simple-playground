import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {
    private static final int POWER_THRESHOLD_TO_MOVE = 3;

    @Test
    @DisplayName("자동차는 정상적으로 이름을 갖는다.")
    void shouldReturnNameForCar() {
        // given
        Car car = new Car("jiyun");

        // when & then
        assertThat(car.getName()).isEqualTo("jiyun");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름에 빈 값이 입력될 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyName(String name) {
        // given & when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차는 움직이기 위한 최소 힘 이상을 전달한 경우 전진한다.")
    void shouldMoveForward_whenMovableValue() {
        // given
        Car car = new Car("jiyun");

        // when
        car.moveForward(POWER_THRESHOLD_TO_MOVE + 1);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 움직이기 위한 최소 힘 미만을 전달할 경우 움직이지 않는다.")
    void shouldStop_whenImmovableValue() {
        // given
        Car car = new Car("jiyun");

        // when
        car.moveForward(POWER_THRESHOLD_TO_MOVE);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
