package car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import car.domain.model.MovingCar;
import car.domain.model.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MovingCarTest {

    private MovingCar car;

    @Nested
    @DisplayName("MovingCar 생성자는")
    class Describe_constructor {

        @Nested
        @DisplayName("유효한 이름이 주어지면")
        class Context_with_valid_name {

            @ParameterizedTest
            @DisplayName("자동차 객체를 생성한다")
            @ValueSource(strings = {"Car1", "MyCar", "A", "12345"})
            void it_creates_moving_car(String name) {
                Name expectedName = new Name(name);
                MovingCar car = new MovingCar(expectedName);

                assertThat(car.getName()).isEqualTo(expectedName.getValue());
                assertThat(car.getLocation()).isEqualTo(0);
            }
        }

        @Nested
        @DisplayName("자동차 이름이 빈 값이거나 공백이면")
        class Context_with_invalid_name_empty_or_blank {

            @ParameterizedTest
            @DisplayName("예외를 던진다")
            @ValueSource(strings = {"", " ", "     "})
            void it_throws_exception(String name) {
                assertThatThrownBy(() -> new MovingCar(new Name(name)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 빈 값일 수 없습니다.");
            }
        }

        @Nested
        @DisplayName("자동차 이름이 5자 초과이면")
        class Context_with_invalid_name_too_long {

            @Test
            @DisplayName("예외를 던진다")
            void it_throws_exception() {
                //given
                String invalidName = "123456";

                // when & then
                assertThatThrownBy(() -> new MovingCar(new Name(invalidName)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    @Nested
    @DisplayName("move 메서드는")
    class Describe_move {

        @BeforeEach
        void setUp() {
            car = new MovingCar(new Name("Test"));
        }

        @Nested
        @DisplayName("이동 가능한 전략이 주어지면")
        class Context_with_movable_strategy {

            @Test
            @DisplayName("자동차가 앞으로 한 칸 이동한다")
            void it_moves_forward() {
                // when
                car.move(() -> true);

                // then
                assertThat(car.getLocation()).isEqualTo(1);
            }
        }
        @Nested
        @DisplayName("이동 불가능한 전략이 주어지면")
        class Context_with_random_value_less_than_threshold {

            @Test
            @DisplayName("자동차가 이동하지 않는다")
            void it_moves_forward() {
                // when
                car.move(() -> false);

                // then
                assertThat(car.getLocation()).isEqualTo(0);
            }
        }
    }

    @Nested
    @DisplayName("isAt 메서드는")
    class Describe_isAt {
        @BeforeEach
        void setUp() {
            car = new MovingCar(new Name("Test"));
        }

        @Test
        @DisplayName("현재 위치와 일치하는 값을 전달하면 true를 반환한다")
        void it_returns_true_when_position_matches() {
            // given: 1칸 이동
            car.move(() -> true);

            // when & then
            assertThat(car.isAt(1)).isTrue();
        }

        @Test
        @DisplayName("현재 위치와 일치하지 않는 값을 전달하면 false를 반환한다")
        void it_returns_false_when_position_differs() {
            // given: 1칸 이동
            car.move(() -> true);

            // when & then
            assertThat(car.isAt(0)).isFalse();
            assertThat(car.isAt(2)).isFalse();
        }
    }
}
