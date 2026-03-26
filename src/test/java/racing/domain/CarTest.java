package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차는 정상적인 이름으로 생성하지 못할경우 예외를 발생시킨다.")
    void create_ValidName() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "abcdef", "po bi", "pobi@"})
    @DisplayName("유효하지 않은 이름으로 생성 시 예외가 발생해야 한다.")
    void create_InvalidName_ThrowsException(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 전진하면 위치가 1 로 변하지 않는다면 예외를 발생시킨다..")
    void move() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
