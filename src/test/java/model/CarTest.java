package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class CarTest {

    private static final int POSITION_THRESHOLD_FOR_MOVE = 4;
    private static final int POSITION_THRESHOLD_FOR_NO_MOVE = 3;
    private String input;

    @BeforeEach
    void setUp() {
        input = "neo,brie,brown";
    }

    @Nested
    @DisplayName("자동차 이름 관련 테스트")
    class CarNameTests {

        @Test
        @DisplayName("자동차 리스트 입력 시 쉼표로 자동차를 분리하는 지 검증한다")
        void testSplitCarName() {
            List<String> carNames = InputView.parseCarNames(input);

            assertThat(carNames).hasSize(3);
        }

        @Test
        @DisplayName("자동차 이름이 5자 이상일 경우 예외가 발생하는 지 검증한다")
        void testCarNameLengthTooLong() {
            assertThatThrownBy(() -> new Car("SuperCar"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("자동차 이름이 5자 이하일 경우 자동차 객체가 정상 생성되는 지 검증한다")
        void testCarNameLengthValid() {
            Car car1 = new Car("Car1");
            assertThat(car1.getCarName()).isEqualTo("Car1");
        }

        @Test
        @DisplayName("자동차 리스트가 null이면 예외가 발생하는 지 검증한다")
        void testGetCarName() {
            String nullInput = null;

            assertThatThrownBy(() -> InputView.parseCarNames(nullInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 리스트가 null이거나 비어있을 수 없습니다.");
        }

        @Test
        @DisplayName("자동차 리스트가 비어있으면 예외가 발생하는 지 검증한다.")
        void testGetCarListIsEmpty() {
            String emptyInput = "";

            assertThatThrownBy(() -> InputView.parseCarNames(emptyInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 리스트가 null이거나 비어있을 수 없습니다.");
        }


        @Test
        @DisplayName("자동차 이름이 비어있으면 예외가 발생하는 지 검증한다.")
        void testGetCarNameIsEmpty() {
            String input = " pobi,,woni";

            assertThatThrownBy(() -> InputView.parseCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("자동차 위치 관련 테스트")
    class CarPositionTests {

        @Test
        @DisplayName("랜덤값이 4 이상일 경우 자동차 위치가 1 증가하는 지 검증한다")
        void testCarPositionIncrease() {
            Car car = new Car("Car1");

            car.move(POSITION_THRESHOLD_FOR_MOVE);
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("랜덤값이 4 미만일 경우 자동차가 이동하지 않는 지 검증한다")
        void testCarPositionNotIncrease() {
            Car car = new Car("Car1");

            car.move(POSITION_THRESHOLD_FOR_NO_MOVE);
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
