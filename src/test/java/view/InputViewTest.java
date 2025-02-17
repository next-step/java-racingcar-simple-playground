package view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 자동차_이름_5자_넘으면_예외_발생_테스트() {
        Exception exception = assertThrows(Exception.class, () -> {
            InputView.validateInput("moremore");
        });
        assertEquals("자동차 이름은 5자 이하여야합니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름이_5자_이하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> InputView.validateInput("haeun"));
        assertDoesNotThrow(() -> InputView.validateInput("ram"));
    }
}