package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private final InputStream standardIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    @DisplayName("자동차 이름 형식이 올바르지 못하면 예외를 발생시킨다.")
    void validateCarNameFormat_Exception() {
        provideInput("pobi,,woni\n");
        assertThatThrownBy(InputView::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외를 발생시킨다.")
    void parseTrialCount_Exception() {
        provideInput("notNumber\n");
        assertThatThrownBy(InputView::inputTrialNumberCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
