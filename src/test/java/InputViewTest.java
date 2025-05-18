import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {
    private final InputStream systemIn = System.in;

    @AfterEach
    void restore() {
        System.setIn(systemIn);
    }
    @Test
    @DisplayName("0 이하 입력 시 IllegalArgumentException 발생")
    void invalidMoveCount(){
        // given
        String testInput ="0\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        // when & then
        assertThatThrownBy(()-> InputView.readMoveCount())
        .isInstanceOf(IllegalArgumentException.class).hasMessage("moveCount는 0보다 큰 값이여야 합니다.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 예외를 던진다")
    void nameTooLong_throwsException() {
        // given
        System.setIn(new ByteArrayInputStream("123456\n".getBytes()));

        // when & then
        assertThatThrownBy(InputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("중복된 이름이 있을 경우 예외를 던진다")
    void duplicateName_throwsException() {
        // given
        System.setIn(new ByteArrayInputStream("aa,bb,aa\n".getBytes()));

        // when & then
        assertThatThrownBy(InputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 모두 고유해야 합니다.");
    }

}
