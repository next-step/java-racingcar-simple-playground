package controllerTest;

import controller.RacingGameController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingGameService;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    @Test
    @DisplayName(", 구분자로 주어진 문자열의 스플릿 테스트")
    void splitByDelimiterTest() {
        RacingGameController racingGameController = new RacingGameController(new RacingGameService());

        String inputNamesTest = "rrr,ccc";
        String[] splitedInputNamesTest = {"rrr", "ccc"};

        assertThat(racingGameController.splitCarNames(inputNamesTest))
                .as("입력값은 ,기준으로 스플릿되지 않았습니다.")
                .isEqualTo(splitedInputNamesTest);
    }
}
