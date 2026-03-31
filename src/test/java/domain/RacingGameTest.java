import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("쉼표로 구분된 자동차의 이름이 2대 미만이면 예외를 던지는지 테스트")
    void testValidateCarNameInput() {
        RacingGame racingGame = new RacingGame();
        String[] testArray = {"I_love_SCG"};
        assertThatThrownBy(() -> racingGame.validateCarNameInput(testArray)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 시도 횟수가 0이하면 예외를 던지는지 테스트")
    void testValidateTryCountInput() {
        RacingGame racingGame = new RacingGame();
        int testTryCountMinus = -1;
        int testTryCount0 = 0;

        assertThatThrownBy(() -> racingGame.validateTryCountInput(testTryCountMinus)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> racingGame.validateTryCountInput(testTryCount0)).isInstanceOf(IllegalArgumentException.class);
    }
}
