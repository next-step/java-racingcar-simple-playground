import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Nested
    public class ConstructorTest {

        @Test
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
        public void 빈_이름으로_자동차_생성() {
            // Given
            String name = "";

            // When & Then
            assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");

        }

        @Test
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
    public class NameTest {

        @Test
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
    public class MoveTest {

        @Test
        public void 자동차가_이동하면_기존위치보다_크거나같다() {
            // Given
            Car car = new Car("테스트카");
            int initialPosition = car.getPosition();

            // When
            car.move();

            // Then
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
        }

        @Test
        public void 여러번_이동_테스트() {
            // Given
            Car car = new Car("테스트카");
            int initialPosition = car.getPosition();

            // When
            for (int i = 0; i < 10; i++) {
                car.move();
            }

            // Then
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
            assertThat(car.getPosition()).isLessThanOrEqualTo(initialPosition + 10);
        }

        @Test
        public void 이동_후_위치는_음수가_될_수_없다() {
            // Given
            Car car = new Car("테스트카");

            // When
            car.move();

            // Then
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Nested
    public class PositionTest {

        @Test
        public void 초기_위치는_영이다() {
            // Given
            Car car = new Car("테스트카");

            // When
            int position = car.getPosition();

            // Then
            assertThat(position).isEqualTo(0);
        }

        @Test
        public void 위치_변화_확인() {
            // Given
            Car car = new Car("테스트카");
            int initialPosition = car.getPosition();

            // When
            car.move();
            int newPosition = car.getPosition();

            // Then
            assertThat(newPosition).isIn(initialPosition, initialPosition + 1);
        }
    }

}
