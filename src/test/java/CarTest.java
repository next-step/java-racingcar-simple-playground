import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Nested
    @DisplayName("자동차 이름 테스트")
    class name {

        @ParameterizedTest
        @ValueSource(strings = {"a", "세글자", "다섯글자5"})
        @DisplayName("이름이 5자 이하면 생성 성공 테스트")
        void 이름이_5자_이하면_생성_성공(String carName) {
            Car car = new Car(carName);

            assertThat(car.getName()).isEqualTo(carName);
        }

        @ParameterizedTest
        @ValueSource(strings = {"여섯글자66", "일곱글자777"})
        @DisplayName("이름이 5자를 초과하면 예외 발생 테스트")
        void 이름이_5자_초과면_예외_발생(String carName) {
            String throwMessage = "자동차 이름은 5자 이하만 가능합니다.";

            assertThatThrownBy(() -> new Car(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(throwMessage);
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        @DisplayName("이름이 비어 있으면 예외 발생 테스트")
        void 이름이_비어있으면_예외_발생(String carName) {
            String throwMessage = "자동차 이름은 비어 있을 수 없습니다.";

            assertThatThrownBy(() -> new Car(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(throwMessage);
        }
    }

    @Nested
    @DisplayName("자동차 이동 테스트")
    class move {

        @Test
        @DisplayName("move() 호출 시 한 칸 전진 테스트")
        void move_호출시_한칸_전진() {
            int expectedPosition = 1;

            Car car = new Car("자동차");
            car.move();

            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }
}
