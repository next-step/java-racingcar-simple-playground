package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import racingcar.fixture.MockNumberGenerator.Number1Generator;
import racingcar.fixture.MockNumberGenerator.Number4Generator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        Car car = new Car("포르쉐");
        assertThat(car.getName()).isEqualTo("포르쉐");
    }

    @Test
    void 자동차의_초기_위치는_0이다() {
        Car car = new Car("포르쉐");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차는_4이상의_수가_나오면_전진한다() {
        Car car = new Car("포르쉐");
        car.move(new Number4Generator());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_3이하의_수가_나오면_전진하지_않는다() {
        Car car = new Car("포르쉐");
        car.move(new Number1Generator());
        assertThat(car.getPosition()).isZero();
    }
}
