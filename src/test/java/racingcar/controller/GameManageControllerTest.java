package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManageControllerTest {
    static final String RACING_GAME_WINNERS = "red, green, blue";

    InputView inputView;
    OutputView outputView;
    InputValidator inputValidator;
    GameManageController gameManageController;

    @BeforeEach
    void setUp() {
        inputView = new InputView() {
            @Override
            public String readCarNames() { // 자동차들의 이름 입력 기능
                return RACING_GAME_WINNERS;
            }

            @Override
            public String readTryCount() {
                return "3";
            }
        };
        outputView = new OutputView();
        inputValidator = new InputValidator();
        gameManageController = new GameManageController(inputView, outputView, inputValidator);
    }

    @Test
    void 레이싱_게임이_정상적으로_실행되고_종료된다() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameManageController.readyRacingGame();

        gameManageController.runRacingGame(() -> 4);

        assertThat(out.toString()).contains(RACING_GAME_WINNERS + "가 최종 우승했습니다.");
    }

}
