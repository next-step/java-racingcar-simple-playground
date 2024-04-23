package org.duckstudy.controller;

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
import org.junit.jupiter.api.Test;

class CarRacingControllerTest {

    private final OutputView outputView = mock(OutputView.class);
    private final InputView inputView = mock(InputView.class);
    private final Validator validator = mock(Validator.class);
    private final Generator generator = mock(Generator.class);
    private final CarRacingController controller = new CarRacingController(inputView, validator, outputView, generator);

    @Test
    @DisplayName("자동차 경주가 성공적으로 진행된다")
    void runSuccessTest() throws IOException {
        String[] carNames = new String[]{"Car1", "Car2", "Car3"};
        int repetitionNum = 1;
        when(inputView.inputCarNames()).thenReturn(carNames);
        when(inputView.inputRepetitionNum()).thenReturn(repetitionNum);
        when(validator.validateRepetitionNum(repetitionNum)).thenReturn(repetitionNum);

        controller.run();

        verify(inputView).inputCarNames();
        verify(inputView).inputRepetitionNum();
        verify(validator).validateRepetitionNum(repetitionNum);
        verify(outputView).printResultStartMessage();
        verify(outputView, times(repetitionNum)).printMessage(anyString());
        verify(outputView).printWinnerNames(anyString());
    }
}
