package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
