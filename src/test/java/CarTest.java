import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {

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
    @DisplayName("자동차는 랜덤 값이 4 이상일 경우 전진할 수 있다.")
    void shouldMoveForward_whenMovableRandomValue() {
        // given
        Car car = new Car("jiyun");

        // when
        int randomValue = 4;
        car.canMove(randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 랜덤 값이 3 이하일 경우 멈춘다.")
    void shouldStop_whenImmovableRandomValue() {
        // given
        Car car = new Car("jiyun");

        // when
        int randomValue = 3;
        car.canMove(randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
