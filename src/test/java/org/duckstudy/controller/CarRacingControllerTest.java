package org.duckstudy.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarRacingControllerTest {

    private final OutputView outputView = mock(OutputView.class);
    private final InputView inputView = mock(InputView.class);
    private final RandomValueGenerator randomValueGenerator = mock(RandomValueGenerator.class);
    private final CarRacingController controller = new CarRacingController(inputView, outputView, randomValueGenerator);
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
}
