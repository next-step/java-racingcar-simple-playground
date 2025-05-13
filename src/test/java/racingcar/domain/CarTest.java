package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.vo.Name;
import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;
import racingcar.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "benz", "bmw", "hyun", "car2"})
    @DisplayName("자동차 생성 테스트")
    void createCar(String name) {
        final Name nameVo = new Name(name);
        final Car car = new Car(nameVo);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ASDFASDF","AAAAAAAAAAAA"})
    @DisplayName("자동차 생성 실패 테스트")
    void createCarFailTooLong(String name) {
        assertThatThrownBy(() -> new Car(new Name(name)))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_NAME_TOO_LONG.getDescription());
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","    "})
    @DisplayName("자동차 생성 실패 테스트")
    void createCarFailEmpty(String name) {
        assertThatThrownBy(() -> new Car(new Name(name)))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_NAME_EMPTY.getDescription());
    }

    @Test
    @DisplayName("숫자가 4이상 일시 자동차 전진 테스트")
    void carMoveTestIfNumberOverFour() {
        final Name nameVo = new Name("car");
        RandomNumberGenerator randomNumberGenerator = () -> 4;
        final Car car = new Car(nameVo);
        car.move(randomNumberGenerator);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 3이하 일시 자동차 정지 테스트")
    void carMoveTestIfNumberUnderThree() {
        final Name nameVo = new Name("car");
        RandomNumberGenerator randomNumberGenerator = () -> 3;
        final Car car = new Car(nameVo);
        car.move(randomNumberGenerator);

        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMoveMultipleTimes() {
        final Name nameVo = new Name("car");
        final Car car = new Car(nameVo);

        car.move(() -> 4);
        car.move(() -> 3);
        car.move(() -> 9);

        assertThat(car.getPosition()).isEqualTo(2);
    }
}
