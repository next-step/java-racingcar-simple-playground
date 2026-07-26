package racingcar.domain;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    public MakeNumStrategy makeNumStrategy;

    @Test
    @DisplayName("자동차는 이름을 가진다")
    void createCarWithName() {
        // given
        Car car = new Car("Car1");

        // when
        String carName = car.getName();

        // then
        assertThat(carName).isEqualTo("Car1");
    }

    @Test
    @DisplayName("자동차는 공백 이름을 가질 수 없다")
    void createCarWithBlankName() {
        // AssertJ를 사용한 예외 검증
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 아닌 5자 이하 글자");
    }

    @Test
    @DisplayName("자동차는 빈 이름을 가질 수 없다")
    void createCarWithNoName() {
        // AssertJ를 사용한 예외 검증
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 아닌 5자 이하 글자");
    }


    @Test
    @DisplayName("자동차는 초기에 위치가 0이다")
    void createCarHasInitialLocationZero() {
        // given
        Car car = new Car("Car2");

        // when
        int location = car.getLocation();

        // then
        assertThat(location).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차_전진_테스트")
    void carMovingTest() {
        // given
        Car car = new Car("Car3");
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();

        // when
        car.moveCar(makeNumStrategy.makeNum());

        // then
        assertEquals(1, car.getLocation());
    }

    @Test
    @DisplayName("자동차_전진하지_않는_테스트")
    void carNotMovingTest() {
//        // given
//        Car car = new Car("Car4");
//
//        // when
//        car.moveCar(!makeNum());
//
//        // then
//        assertEquals(0, car.getLocation());
    }
}
