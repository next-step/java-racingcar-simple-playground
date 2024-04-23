package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.stream.Stream;
import org.duckstudy.model.generator.DefaultRandomValueGenerator;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 테스트")
class CarTest {
    @Nested
    @DisplayName("자동차 이름 검증 테스트")
    class CarNameValidationTest {

        private final RandomValueGenerator randomValueGenerator = new DefaultRandomValueGenerator();
        private String[] carNames;

        @Test
        @DisplayName("자동차 이름이 5글자 이내일때 성공한다")
        void gameSuccessWhenCarNameIsLessThan5() {
            carNames = new String[]{"Car1"};

            assertThatCode(() -> new Cars(carNames, randomValueGenerator))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @MethodSource("methodSourceCarNameLengthTestArguments")
        @DisplayName("자동차 이름이 없거나 5글자 초과일 때 에러를 발생한다")
        void gameFailWhenCarNameLengthIsEmptyOrGreaterThan5(String[] carNames) {
            assertThatThrownBy(() -> new Cars(carNames, randomValueGenerator))
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

        private RandomValueGenerator randomValueGenerator;
        private Car car;

        @ParameterizedTest
        @ValueSource(ints = {4, 9})
        @DisplayName("random 값이 4 이상 9 이하인 경우 1만큼 전진한다")
        void moveCarWhenRandomValueIsGreaterThanOrEqual4(int randomValue) {
            randomValueGenerator = () -> randomValue;
            car = new Car("Car1", randomValueGenerator);

            car.move();

            assertThat(car.getPosition()).isEqualTo(1L);
        }

        @Test
        @DisplayName("random 값이 3 이하인 경우 멈춘다")
        void stopCarWhenRandomValueIsLessThan4() {
            randomValueGenerator = () -> 3;
            car = new Car("Car1", randomValueGenerator);

            car.move();

            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
