package controller;

import domain.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameControllerTest {

    private RacingGameController racingGameController;

    @BeforeEach
    void setUp() {
        racingGameController = new RacingGameController(new RandomGenerator());
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 예외가 발생한다.")
    void shouldThrowException_WhenCarNameExceedsMaxLength() {
        List<String> invalidCarNames = List.of("abcdef", "ghi");

        assertThatThrownBy(() -> racingGameController.validateNameLength(invalidCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하일 경우 예외가 발생하지 않는다.")
    void shouldNotThrowException_WhenCarNameIsValid() {
        List<String> validCarNames = List.of("neo", "brie");

        assertThatCode(() -> racingGameController.validateNameLength(validCarNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("라운드 수가 0 이하일 경우 예외가 발생한다.")
    void shouldThrowException_WhenRoundsIsZeroOrNegative() {
        assertThatThrownBy(() -> racingGameController.ensurePositiveRounds(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 1이상이어야 합니다.");

        assertThatThrownBy(() -> racingGameController.ensurePositiveRounds(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 1이상이어야 합니다.");
    }

    @Test
    @DisplayName("라운드 수가 1 이상일 경우 정상적으로 반환된다.")
    void shouldReturnRounds_WhenValid() {
        int validRounds = 3;

        assertThat(racingGameController.ensurePositiveRounds(validRounds)).isEqualTo(3);
    }
}