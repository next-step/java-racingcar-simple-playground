import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ExceptionTest {
    @Test
    @DisplayName("자동차 이름 5자 넘어가면 unchecked exception 발생하는지 테스트")
    void uncheckedException() {
        String[] testCarNameNoException = new String[] {"1111", "2222", "3333", "44444"};
        String[] testCarNameHasException = new String[]{"qqq", "wwww", "eeeee", "rrrrrrr"};

        assertAll(
                () -> assertThatCode(() -> InputView.carNameLengthCheck(testCarNameNoException)).doesNotThrowAnyException(),
                () -> assertThatThrownBy(() -> InputView.carNameLengthCheck(testCarNameHasException)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5자 이하만 가능합니다.")
        );
    }
}
