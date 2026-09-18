import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CarTest {
    @Test
    @DisplayName("전진 조건이 참이면 위치가 증가한다.")
    void increasePositionWhenMovable() {
        Car car = new Car("실험용1");
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 위치와 같으면 참을 반환한다.")
    void returnTrueWhenSamePosition() {
        Car car = new Car("실험용2");
        car.move();
        car.move();
        car.move();

        assertTrue(car.isSamePosition(3));
    }

    @Test
    @DisplayName("주어진 위치와 다르면 거짓을 반환한다.")
    void returnFalseWhenNotSamePosition() {
        Car car = new Car("실험용2");
        car.move();
        car.move();
        car.move();

        assertFalse(car.isSamePosition(2));
    }

    @Test
    @DisplayName("생성 시 지정한 이름을 반환한다.")
    void returnGivenName() {
        Car car = new Car("실험용3");
        assertThat(car.getName()).isEqualTo("실험용3");
    }

    @ParameterizedTest
    @DisplayName("숫자에 따라 이동 가능 여부가 결정된다.")
    @CsvSource({
            "3, false",
            "4, true",
            "0, false",
            "9, true"
    })

    void determineMovableByNumber(int number, boolean expected) {
        assertThat(Car.isMovable(number)).isEqualTo(expected);
    }

}
