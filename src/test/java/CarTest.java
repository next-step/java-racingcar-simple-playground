import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void carNameLengthTest() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @DisplayName("자동차 이름이 null, 빈 문자열, 또는 공백이면 예외가 발생한다")
    void blankCarNameTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다");
    }

    @Test
    @DisplayName("랜덤 값이 3 이하이면 정지한다 (위치 변화 없음)")
    void stopTest() {
        Car car = new Car("a");
        car.move(3); // 3 이하일 때

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 1칸 전진한다")
    void moveTest() {
        Car car = new Car("a");
        car.move(4);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
