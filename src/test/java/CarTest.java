import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import strategy.FixedMoveStrategy;

public class CarTest {

    @Nested
    @DisplayName("자동차 생성 테스트")
    public class ConstructorTest {

        @Test
        @DisplayName("정상적인 이름으로 자동차가 생성된다")
        public void 자동차_생성_성공() {
            // Given
            String name = "테스트카";

            // When
            Car car = new Car(name);

            // Then
            assertThat(car).isNotNull();
            assertThat(car.getName()).isEqualTo(name);
            assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("빈 이름으로 자동차 생성 시 예외가 발생한다")
        public void 빈_이름으로_자동차_생성() {
            // Given
            String name = "";

            // When & Then
            assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
        }

        @Test
        @DisplayName("공백 이름으로 자동차 생성 시 예외가 발생한다")
        public void 공백_이름으로_자동차_생성() {
            // Given
            String name = "   ";

            // When & Then
            assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
        }

    }

    @Nested
    @DisplayName("자동차 이름 테스트")
    public class NameTest {

        @Test
        @DisplayName("자동차 이름이 올바르게 반환된다")
        public void 자동차_이름_확인() {
            // Given
            String expectedName = "이름";
            Car car = new Car(expectedName);

            // When
            String actualName = car.getName();

            // Then
            assertThat(actualName).isEqualTo(expectedName);
        }

        @Test
        @DisplayName("특수문자가 포함된 이름이 올바르게 저장된다")
        public void 특수문자_포함_이름() {
            // Given
            String specialName = "자동차@#$%";
            Car car = new Car(specialName);

            // When
            String actualName = car.getName();

            // Then
            assertThat(actualName).isEqualTo(specialName);
        }

    }

    @Nested
    @DisplayName("자동차 위치 테스트")
    public class PositionTest {

        @Test
        @DisplayName("자동차의 초기 위치는 0이다")
        public void 초기_위치는_영이다() {
            // Given
            Car car = new Car("테스트카");

            // When
            int position = car.getPosition();

            // Then
            assertThat(position).isEqualTo(0);
        }

        @Test
        @DisplayName("자동차 위치는 항상 0 이상이다")
        public void 위치는_음수가_아니다() {
            // Given
            Car car = new Car("테스트카");
            FixedMoveStrategy moveStrategy = new FixedMoveStrategy(true);

            // When
            car.move(moveStrategy);

            // Then
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Nested
    @DisplayName("자동차 이동 테스트")
    public class MoveTest {

        @Test
        @DisplayName("움직일 수 있는 상태일 때 자동차가 이동한다")
        public void 자동차는_움직일수있다면_이동한다() {
            // Given
            Car car = new Car("테스트카");
            FixedMoveStrategy moveStrategy = new FixedMoveStrategy(true);

            // When
            car.move(moveStrategy);

            // Then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("계속 정지하면 위치가 변하지 않는다")
        public void 계속_정지() {
            // Given
            Car car = new Car("테스트카");
            FixedMoveStrategy stopStrategy = new FixedMoveStrategy(false);

            // When
            car.move(stopStrategy);
            car.move(stopStrategy);
            car.move(stopStrategy);

            // Then
            assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("10번 이동하면 위치가 10이 된다")
        public void 십번_이동_테스트() {
            // Given
            Car car = new Car("테스트카");
            FixedMoveStrategy moveStrategy = new FixedMoveStrategy(true);

            // When
            for (int i = 0; i < 10; i++) {
                car.move(moveStrategy);
            }

            // Then
            assertThat(car.getPosition()).isEqualTo(10);
        }
    }
}
