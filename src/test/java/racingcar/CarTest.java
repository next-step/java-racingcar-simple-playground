package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.fixture.Random0GeneratorImpl;
import racingcar.fixture.Random4GeneratorImpl;
import racingcar.domain.Car;

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가지고 있다.")
    void carName() {
        Car car = new Car("아무차");
        assertThat(car.getName()).isEqualTo("아무차");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 null이면 예외")
    @NullSource
    @ValueSource(strings = {" "})
    void carNameNull(String name) {
        assertThrows(RuntimeException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과면 예외")
    void carNameLengthMoreThan5() {
        assertThrows(RuntimeException.class, () -> new Car("123456"));
    }

    @Test
    @DisplayName("자동차의 시작위치는 0")
    void firstPosition() {
        Car car = new Car("아무차");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("랜덤 값이 3 이하면 자동차는 멈춘다.")
    void carStop() {
        Car car = new Car("아무차");
        car.move(new Random0GeneratorImpl());

        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 자동차는 전진한다.")
    void carMove() {
        Car car = new Car("아무차");
        car.move(new Random4GeneratorImpl());

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
