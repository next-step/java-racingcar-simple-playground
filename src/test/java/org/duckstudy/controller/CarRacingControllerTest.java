package org.duckstudy.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import org.duckstudy.model.car.Cars;
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
    private final Cars cars = mock(Cars.class);

    @Test
    @DisplayName("자동차 경주가 성공적으로 진행된다")
    void runSuccessTest() throws IOException {
        String[] carNames = new String[]{"Car1", "Car2", "Car3"};
        Cars winners = new Cars(Arrays.copyOfRange(carNames, 0, 2), generator);
        int repetitionNum = 1;
        when(inputView.inputCarNames()).thenReturn(carNames);
        when(inputView.inputRepetitionNum()).thenReturn(repetitionNum);
        when(validator.validateCarNames(carNames)).thenReturn(carNames);
        when(validator.validateRepetitionNum(repetitionNum)).thenReturn(repetitionNum);
        when(generator.generateValue()).thenReturn(4, 4, 1);
        when(cars.playAndGetWinners(repetitionNum, outputView)).thenReturn(winners);

        controller.run();

        verify(inputView).inputCarNames();
        verify(inputView).inputRepetitionNum();
        verify(validator).validateCarNames(carNames);
        verify(validator).validateRepetitionNum(repetitionNum);
        verify(outputView).printResultStartMessage();
        verify(outputView, times(repetitionNum)).printMessage("Car1 : -\nCar2 : -\nCar3 : \n");
        verify(outputView).printWinnerNames(eq(winners.getNames()));
    }
}
