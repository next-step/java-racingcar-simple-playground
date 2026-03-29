package movingCarGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import movingCarGame.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Test
    @DisplayName("정상 입력을 파싱한다")
    void testParseNamesSuccess() {
        assertThat(Application.parseNames("a,b"))
                .extracting(Car::getName)
                .containsExactly("a", "b");
    }

    @Test
    @DisplayName("이름이 5자를 넘으면 예외 발생")
    void testParseNamesFailForLength() {
        assertThatThrownBy(() -> Application.parseNames("abcdef,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("빈 이름이 포함되면 예외 발생")
    void testParseNamesFailForEmpty() {
        assertThatThrownBy(() -> Application.parseNames(",b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 최소 한글자를 넣어야 합니다.");
    }

    @Test
    @DisplayName("반복 횟수를 정상적으로 파싱한다")
    void testParseCountSuccess() {
        assertThat(Application.parseCount("3"))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다")
    void testParseCountFailForNonNumeric() {
        assertThatThrownBy(() -> Application.parseCount("abcde"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("반복 횟수가 1 미만이면 예외가 발생한다")
    void testParseCountFailForLessThanOne() {
        assertThatThrownBy(() -> Application.parseCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("반복 횟수가 100을 초과하면 예외가 발생한다")
    void testParseCountFailForOverMax() {
        assertThatThrownBy(() -> Application.parseCount("121"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100 이하로 입력해주세요.");
    }

    @Test
    @DisplayName("반복 횟수로 1을 입력할 수 있다")
    void testParseCountSuccessMinBound() {
        assertThat(Application.parseCount("1"))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("반복 횟수로 100을 입력할 수 있다")
    void testParseCountSuccessMaxBound() {
        assertThat(Application.parseCount("100"))
                .isEqualTo(100);
    }
}
