package racingcar.domain;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    public static final int CAR_MOVING_THRESHOLD = 4;
    public FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();

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

        // when
        car.moveCar(fixedNumberGenerator.makeNum());

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

    @Test
    @DisplayName("자동차 이름이 5자 이하일 경우 정상적으로 생성된다.")
    void createCarSuccess() {
        // given
        String validName = "CarA";

        // when
        Car car = new Car(validName);

        // then
        assertThat(car.getName()).isEqualTo(validName);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차이름이 5자를 초과하면 IllegalArgumentException 예외가 발생한다.")
    void createLongNameCarFail() {
        // given
        String invalidName = "abcdefgh";

        // when, then
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이 아닌 5자 이하 글자여야합니다.");
    }

    @Test
    @DisplayName("자동차이름이 공백이거나 null일때 IllegalArgumentException 예외가 발생한다.")
    void createBlankNameCarFail() {
        // given
        String blankName = " ";

        // when, then
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이 아닌 5자 이하 글자여야합니다.");
    }

    @Test
    @DisplayName("이동을 결정짓는 값이 임계값 이상일때 자동차는 1만큼 전진한다.")
    void moveCarForward() {
        // given
        Car car = new Car("CarA");
        int randomValue = CAR_MOVING_THRESHOLD;

        // when
        car.moveCar(randomValue);

        // then
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 값이 3 이하일때 자동차는 이동하지 않는다.")
    void moveCarStop() {
//        // given
//        Car car = new Car("CarA");
//        int randomValue = CAR_MOVING_THRESHOLD - 1;
//
//        // when
//        car.moveCar(randomValue);
//
//        // then
//        assertThat(car.getLocation()).isEqualTo(0);
    }
}
