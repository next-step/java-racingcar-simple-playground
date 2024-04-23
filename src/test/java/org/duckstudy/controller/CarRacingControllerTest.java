package org.duckstudy.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import org.duckstudy.model.generator.Generator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarRacingControllerTest {

    private final OutputView outputView = mock(OutputView.class);
    private final InputView inputView = mock(InputView.class);
    private final Generator generator = mock(Generator.class);
    private final CarRacingController controller = new CarRacingController(inputView, outputView, generator);
    private final String[] carNames = new String[]{"Car1", "Car2", "Car3"};

    @Nested
    @DisplayName("자동차 경주 흐름 테스트")
    class CarRaceRunningTest {
        @Test
        @DisplayName("자동차 경주가 성공적으로 진행된다")
        void runSuccessTest() throws IOException {
            int repetitionNum = 1;
            when(inputView.inputCarNames()).thenReturn(carNames);
            when(inputView.inputRepetitionNum()).thenReturn(repetitionNum);

            controller.run();

            verify(inputView).inputCarNames();
            verify(inputView).inputRepetitionNum();
            verify(outputView).printResultStartMessage();
            verify(outputView, times(repetitionNum)).printMessage(anyString());
            verify(outputView).printWinnerNames(anyString());
        }
    }

    @Nested
    @DisplayName("반복 횟수 검증 테스트")
    class RepetitonNumValidationTest {
        @Test
        @DisplayName("반복 횟수가 0보다 클때 성공한다")
        void gameSuccessWhenRepetitionNumIsGreaterThan0() throws IOException {
            int repetitionNum = 1;
            when(inputView.inputCarNames()).thenReturn(carNames);
            when(inputView.inputRepetitionNum()).thenReturn(repetitionNum);

            assertThatCode(controller::run)
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("반복 횟수가 0 이하이면 정상 입력할 때까지 입력을 받는다.")
        void gameFailWhenRepetitionNumIsEqualOrLessThan0() throws IOException {
            int repetitionNum = 0;
            when(inputView.inputCarNames()).thenReturn(carNames);
            when(inputView.inputRepetitionNum()).thenReturn(repetitionNum).thenReturn(1);

            assertThatCode(controller::run)
                    .doesNotThrowAnyException();
            verify(outputView, times(1)).printException(any(IllegalArgumentException.class));
        }
    }
}
