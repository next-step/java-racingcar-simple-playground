package controller;

import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameControllerTest {

    private String input;

    @BeforeEach
    void setUp() {
        input = "현대,기아,쌍용" + System.lineSeparator() + 3;
    }

    @Test
    void 우승자가_한_명_이상_존재할_수_있다() {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        RacingGameController controller = new RacingGameController(new MoveNumberGenerator());
        controller.run();
        Cars winners = controller.getWinners();
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 우승자가_정해지지_않은_상태에서_우승자를_조회하면_예외가_발생한다() {
        RacingGameController controller = new RacingGameController(new MoveNumberGenerator());
        assertThatThrownBy(() -> controller.getWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("레이싱 게임이 아직 시작되지 않았습니다!");
    }
}
