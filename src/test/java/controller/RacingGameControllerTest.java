package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.ResultView;

class RacingGameControllerTest {

    RacingGameController racingGameController = new RacingGameController(new InputView(), new ResultView());

    @Test
    @DisplayName("자동차 이름이 비어있을 때 예외가 발생한다.")
    public void validateCarsName_CaseByCarNameIsBlankTest() {
        String carName = "gold, ,RuKa";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.validateCarsName(carName);
        });

        Assertions.assertEquals("자동차 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 때 예외가 발생한다.")
    public void validateCarsName_CaseByCarNameIsOverFiveWordsTest() {
        String carName = "goldmong,kokodak,RuKa";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.validateCarsName(carName);
        });

        Assertions.assertEquals("자동차 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("레이스 횟수가 1보다 작을 경우 예외가 발생한다.")
    public void validateRaceCountTest() {
        int raceCount1 = 0;
        int raceCount2 = -1;

        IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                racingGameController.validateRaceCount(raceCount1));
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                racingGameController.validateRaceCount(raceCount2));

        Assertions.assertEquals("레이스 횟수는 1 이상이어야 합니다.", exception1.getMessage());
        Assertions.assertEquals("레이스 횟수는 1 이상이어야 합니다.", exception2.getMessage());
    }
}