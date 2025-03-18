import static org.junit.jupiter.api.Assertions.assertThrows;

import CarGame2.InputHandler;
import CarGame2.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();

    @Test
    @DisplayName("자동차 이름이 공백이면 예외 발생")
    void 자동차_이름_공백_예외() {
        assertThrows(InvalidInputException.class, () -> inputHandler.validateCarNames(""));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외 발생")
    void 자동차_이름_길이_초과_예외() {
        assertThrows(InvalidInputException.class, () -> inputHandler.validateCarNames("longname"));
    }

    @Test
    @DisplayName("시도 횟수가 음수이면 예외 발생")
    void 시도_횟수_음수_예외() {
        assertThrows(InvalidInputException.class, () -> inputHandler.validateRounds("-3"));
    }
}
