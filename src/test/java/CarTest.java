import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 정상적으로 이름을 갖는다.")
    void shouldReturnNameForCar() {
        // given
        Car car = new Car("jiyun");

        // when & then
        assertThat(car.getName()).isEqualTo("jiyun");
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
