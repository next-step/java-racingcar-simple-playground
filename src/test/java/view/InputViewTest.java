package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"1.5", "aa"})
    @DisplayName("게임 라운드 정수 입력 테스트: 예외 발생")
    void invalidInputGameRounds(String input) {
        // Given
        System.setIn(new ByteArrayInputStream((input + "\n").getBytes()));
        InputView inputView = new InputView();

        // When & Then
        assertThatThrownBy(inputView::readGameRounds)
            .isInstanceOf(IllegalArgumentException.class);
    }
}
