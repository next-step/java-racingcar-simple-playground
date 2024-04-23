package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.model.generator.DefaultRandomValueGenerator;
import org.duckstudy.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
class CarsTest {
    @Nested
    @DisplayName("반복 횟수 검증 테스트")
    class RepetitonNumValidationTest {

        private final String[] carNames = new String[]{"Car1", "Car2", "Car3"};
        private final RandomValueGenerator randomValueGenerator = new DefaultRandomValueGenerator();
        private OutputView outputView;
        private Cars cars;
        private int repetitionNum;

        @Test
        @DisplayName("반복 횟수가 0보다 클때 성공한다")
        void gameSuccessWhenRepetitionNumIsGreaterThan0() {
            outputView = new OutputView();
            cars = new Cars(carNames, randomValueGenerator, outputView);
            repetitionNum = 1;

            assertThatCode(() -> cars.playAndGetWinners(repetitionNum, outputView))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("반복 횟수가 0 이하이면 에러가 발생하고, 정상 입력할 때까지 입력을 받는다")
        void gameFailWhenRepetitionNumIsEqualOrLessThan0() {
            outputView = mock(OutputView.class);
            cars = new Cars(carNames, randomValueGenerator, outputView);
            repetitionNum = 0;

            assertThatThrownBy(() -> cars.playAndGetWinners(repetitionNum, outputView))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
            verify(outputView, times(1)).getRepetitionNumExceptionMessage();
        }
    }

    @Nested
    @DisplayName("결과 테스트")
    class CarRaceResultTest {

        private final String[] carNames = new String[]{"Car1", "Car2", "Car3"};
        private final RandomValueGenerator randomValueGenerator = new DefaultRandomValueGenerator();
        private final OutputView outputView = new OutputView();
        private final Cars cars = mock(Cars.class);

        @Test
        @DisplayName("경주가 완료되면 우승자를 계산한다")
        void calculateWinnerWhenRaceIsOver() {
            String[] selectedWinnerNames = Arrays.copyOfRange(carNames, 0, 2);
            Cars selectedWinners = new Cars(selectedWinnerNames, randomValueGenerator, outputView);
            doReturn(selectedWinners).when(cars).playAndGetWinners(anyInt(), any(OutputView.class));

            Cars winners = cars.playAndGetWinners(5, outputView);

            assertAll(
                    () -> assertThat(winners.getCars().size()).isEqualTo(selectedWinnerNames.length),
                    () -> assertThat(winners.getCars().get(0).getName()).isEqualTo(selectedWinnerNames[0]),
                    () -> assertThat(winners.getCars().get(1).getName()).isEqualTo(selectedWinnerNames[1])
            );
        }
    }
}
