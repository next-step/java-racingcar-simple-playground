package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("자동차 테스트")
class CarTest {

    @Nested
    @DisplayName("자동차 이름 검증 테스트")
    class CarNameValidationTest {

        @Test
        @DisplayName("자동차 이름이 5글자 이내일때 성공한다")
        void gameSuccessWhenCarNameIsLessThan5() {
            String[] carNames = new String[]{"Car1"};

            assertThatCode(() -> new Cars(carNames, () -> true))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @MethodSource("methodSourceCarNameLengthTestArguments")
        @DisplayName("자동차 이름이 없거나 5글자 초과일 때 에러를 발생한다")
        void gameFailWhenCarNameLengthIsEmptyOrGreaterThan5(String[] carNames) {
            assertThatThrownBy(() -> new Cars(carNames, () -> true))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 1글자 이상 5글자 이하만 가능합니다.\n");
        }

        private static Stream<Arguments> methodSourceCarNameLengthTestArguments() {
            return Stream.of(
                    Arguments.arguments((Object) new String[]{""}),
                    Arguments.arguments((Object) new String[]{"abcdef"})
            );
        }
    }

    @Nested
    @DisplayName("자동차 이동 테스트")
    class CarMoveTest {
        @Test
        @DisplayName("이동 조건이 참일 때 1만큼 전진한다")
        void moveCarWhenRandomStrategyIsMovable() {
            Car car = new Car("Car1", () -> true);

            car = car.move();

            assertThat(car.getPosition()).isEqualTo(1L);
        }

        @Test
        @DisplayName("이동 조건이 거짓이면 전진하지 않는다")
        void stopCarWhenRandomStrategyIsNotMovable() {
            Car car = new Car("Car1", () -> false);

            car = car.move();

            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
