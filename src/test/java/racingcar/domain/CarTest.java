package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {
    public static final int CAR_MOVING_THRESHOLD = 4;
    public FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();

    Car car = new Car("Car1");

    @Nested
    @DisplayName("Car 생성자로 인스턴스를 생성하면")
    public class Describe_Car {
        @Test
        @DisplayName("자동차는 이름을 가진다")
        void createCarWithName() {
            String carName = car.getName();

            assertThat(carName).isEqualTo("Car1");
        }

        @Test
        @DisplayName("자동차는 초기에 위치가 0이다")
        void createCarHasInitialLocationZero() {
            int location = car.getLocation();

            assertThat(location).isEqualTo(0);
        }

        @Nested
        @DisplayName("자동차는 이동을 결정짓는 값이 임계값 이상일때 1 전진한다")
        public class CallMoveCar{
            @Test
            @DisplayName("자동차는 위치 1만큼 전진한다")
            void carMovingTest() {
                car.moveCar(fixedNumberGenerator.makeNum());

                assertEquals(1, car.getLocation());
            }

            @Test
            @DisplayName("이동을 결정짓는 값이 임계값 이상일때 자동차는 1만큼 전진한다.")
            void moveCarForward() {
                int randomValue = CAR_MOVING_THRESHOLD;

                car.moveCar(randomValue);

                assertThat(car.getLocation()).isEqualTo(1);
            }
        }
    }

    @Test
    @DisplayName("자동차는 전진하지 않고 기존 위치에 멈춰있다.")
    void carNotMovingTest() {
//        // when
//        car.moveCar(!makeNum());
//
//        // then
//        assertEquals(0, car.getLocation());
    }

    @Test
    @DisplayName("무작위 값이 3 이하일때 자동차는 이동하지 않는다.")
    void moveCarStop() {
//        // given
//        int randomValue = CAR_MOVING_THRESHOLD - 1;
//
//        // when
//        car.moveCar(randomValue);
//
//        // then
//        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하일 경우 정상적으로 생성된다.")
    void createCarSuccess() {
        String validName = "CarA";
        Car car = new Car(validName);

        assertThat(car.getName()).isEqualTo(validName);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Nested
    @DisplayName("자동차 이름에 관련된 예외 발생시 정상적으로 처리된다.")
    public class ExceptionTest{
        @Test
        @DisplayName("자동차는 공백 이름을 가질 수 없다")
        void createCarWithBlankName() {
            assertThatThrownBy(() -> new Car(" ")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백이 아닌 5자 이하 글자");
        }

        @Test
        @DisplayName("자동차는 빈 이름을 가질 수 없다")
        void createCarWithNoName() {
            assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백이 아닌 5자 이하 글자");
        }

        @Test
        @DisplayName("자동차이름이 5자를 초과하면 IllegalArgumentException 예외가 발생한다.")
        void createLongNameCarFail() {
            String invalidName = "abcdefgh";

            assertThatThrownBy(() -> new Car(invalidName)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 공백이 아닌 5자 이하 글자여야합니다.");
        }

        @Test
        @DisplayName("자동차이름이 공백이거나 null일때 IllegalArgumentException 예외가 발생한다.")
        void createBlankNameCarFail() {
            String blankName = " ";

            assertThatThrownBy(() -> new Car(blankName)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 공백이 아닌 5자 이하 글자여야합니다.");
        }
    }

}
