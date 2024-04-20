package org.duckstudy.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;
import org.duckstudy.generator.Generator;
import org.duckstudy.generator.RandomValueGenerator;
import org.duckstudy.movingcar.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("입력값 검증 테스트")
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();
    private final Generator generator = new RandomValueGenerator();
    private final Cars cars = mock(Cars.class);

    @Nested
    @DisplayName("입력값 검증 테스트")
    class inputValidationTest {
        @ParameterizedTest
        @MethodSource("methodSourceCarNameLengthTestArguments")
        @DisplayName("자동차 이름이 없거나 5글자 초과일 때 에러를 발생한다")
        void gameFailWhenCarNameLengthIsEmptyOrGreaterThan5(String[] carNames) {

            assertThatThrownBy(() -> inputValidator.validateInput(1, carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 1글자 이상 5자 이하만 가능합니다.");
        }

        private static Stream<Arguments> methodSourceCarNameLengthTestArguments() {
            return Stream.of(
                    Arguments.arguments((Object) new String[]{""}),
                    Arguments.arguments((Object) new String[]{"abcdef"})
            );
        }

        @Test
        @DisplayName("반복 횟수가 0 이하일때 에러를 발생한다")
        void gameFailWhenRepetitionNumIsEqualOrLessThan0() {
            String[] carNames = new String[]{"abc", "def"};
            int repetitionNum = 0;

            assertThatThrownBy(() -> inputValidator.validateInput(repetitionNum, carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복 횟수는 0보다 커야 합니다.");
        }
    }

//    @Nested
//    @DisplayName("게임 진행 테스트")
//    class gamePlayTest {
//
//        @Test
//        @DisplayName("경주가 완료되면 우승자를 계산한다")
//        void calculateWinnerWhenRaceIsOver() {
//            String[] carNames = new String[]{"Car1", "Car2", "Car3"};
//            List<String> selectedWinnerNames = Arrays.asList(carNames).subList(0, 2);
//            Racer racer = new Racer(3, 5, carNames);
//
//            doAnswer(invocation -> {
//                List<Car> carList = invocation.getArgument(0, List.class);
//                carList.stream().filter(car -> selectedWinnerNames.contains(car.getName()))
//                        .forEach(Car::move);
//                return null;
//            }).when(cars).play(anyInt());
//
//            ArrayList<Car> winners = cars.play(5);
//
//            assertAll(
//                    () -> assertThat(winners.size()).isEqualTo(selectedWinnerNames.size()),
//                    () -> winners.stream().map(Car::getName).map(selectedWinnerNames::contains)
//                            .forEach(Assertions::assertTrue)
//            );
//        }
//    }
}
