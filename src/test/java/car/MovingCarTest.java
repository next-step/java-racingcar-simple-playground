package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("움직이는 자동차 테스트")
public class MovingCarTest {

    private MovingCar car;

    @BeforeEach
    void setUp() {
        car = new MovingCar("TestCar");
    }

    @Nested
    @DisplayName("move 메서드는")
    class Describe_move {

        @Nested
        @DisplayName("임계값 이상의 값이 주어지면")
        class Context_with_random_value_greater_than_or_equal_to_threshold {

            @ParameterizedTest
            @DisplayName("자동차가 앞으로 한 칸 이동한다")
            @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
            void it_moves_forward(int randomValue) {
                car.move(randomValue); // 임계값 4 이상

                assertThat(car.getName()).isEqualTo("TestCar");
                assertThat(car.getLocation()).isEqualTo(1);
            }
        }
        @Nested
        @DisplayName("임계값 미만의 값이 주어지면")
        class Context_with_random_value_less_than_threshold {

            @ParameterizedTest
            @DisplayName("자동차가 이동하지 않는다")
            @ValueSource(ints = {0, 1, 2, 3})
            void it_moves_forward(int randomValue) {
                car.move(randomValue); // 임계값 4 미만

                assertThat(car.getName()).isEqualTo("TestCar");
                assertThat(car.getLocation()).isEqualTo(0);
            }
        }



    }

}
