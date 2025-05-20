import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 테스트")
public class CarTest {

    @Test
    @DisplayName("이름은 5자 이하일 때 생성 가능")
    void createCarWithValidName() {
        assertThatCode(() -> new Car("pobi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 6자 이상이면 예외 발생")
    void createCarWithInvalidName() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("차량 이름은 5자 이하여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("숫자가 4 이상이면 전진한다.")
    void moveForward(int generatedNumber) {
        Car car = new Car("test");
        car.move(generatedNumber);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("숫자가 4 미만이면 전진하지 않는다.")
    void doNotMove() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }

}

