package org.duckstudy.racer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("자동차 게임 테스트")
class RacerTest {

    private CarMover carMover;
    private String[] nameList;

    @BeforeEach
    void setUp() {
        carMover = mock(CarMover.class);
    }

    @Nested
    @DisplayName("입력값 검증 테스트")
    class inputValidationTest {

        @ParameterizedTest
        @MethodSource("methodSourceCarNameLengthTestArguments")
        @DisplayName("자동차 이름이 없거나 5글자 초과일 때 에러를 발생한다")
        void gameFailWhenCarNameLengthIsEmptyOrGreaterThan5(String[] nameList) {

            assertThatThrownBy(() -> new Racer(carMover, 1, 5, nameList))
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
            nameList = new String[]{"abc", "def"};
            int repetitionNum = 0;

            assertThatThrownBy(() -> new Racer(carMover, 2, repetitionNum, nameList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복 횟수는 0보다 커야 합니다.");
        }
    }

    @Nested
    @DisplayName("게임 진행 테스트")
    class gamePlayTest {

        @Test
        @DisplayName("경주가 완료되면 우승자를 계산한다")
        void calculateWinnerWhenRaceIsOver() {
            nameList = new String[]{"Car1", "Car2", "Car3"};
            List<String> selectedWinnerNames = Arrays.asList(nameList).subList(0, 2);
            Racer racer = new Racer(carMover, 3, 5, nameList);

            doAnswer(invocation -> {
                List<Car> carList = invocation.getArgument(0, List.class);
                carList.stream().filter(car -> selectedWinnerNames.contains(car.getName()))
                        .forEach(Car::move);
                return null;
            }).when(carMover).move(anyList());

            ArrayList<Car> winnerList = racer.play();

            assertAll(
                    () -> assertThat(winnerList.size()).isEqualTo(selectedWinnerNames.size()),
                    () -> winnerList.stream().map(Car::getName).map(selectedWinnerNames::contains)
                            .forEach(Assertions::assertTrue)
            );
        }
    }
}
