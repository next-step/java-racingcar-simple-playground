import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Nested
    @DisplayName("하나의 자동차로 이동 규칙")
    class MoveRule {

        @ParameterizedTest
        @CsvSource({
                "0, 0",
                "1, 0",
                "2, 0",
                "3, 0",
                "4, 1",
                "5, 1",
                "9, 1"
        })
        @DisplayName("랜덤값이 4 이상이면 +1하고, 3 이하면 0이다.")
        void movesDependingOnRandomNumber(int randomNumber, int expectedPosition) {
            Car car = new Car("moew");

            car.move(new FixedNumberGenerator(randomNumber));

            assertThat(car.position()).isEqualTo(expectedPosition);
        }

        @Test
        @DisplayName("여러 번 이동하면 전진 조건을 만족한 횟수만큼 position이 증가한다")
        void movesMultipleTimes() {
            Car car = new Car("moew");

            car.move(new FixedNumberGenerator(4));
            car.move(new FixedNumberGenerator(3));
            car.move(new FixedNumberGenerator(9));

            assertThat(car.position()).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("자동차 기본 상태")
    class BasicState {

        @Test
        @DisplayName("자동차는 이름을 가진다")
        void hasName() {
            Car car = new Car("moew");

            assertThat(car.name()).isEqualTo("moew");
        }

        @Test
        @DisplayName("생성 직후 position은 0이다")
        void initialPositionIsZero() {
            Car car = new Car("moew");

            assertThat(car.position()).isZero();
        }
    }
}
