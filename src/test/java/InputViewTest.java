import view.InputView;
import java.lang.reflect.Method;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름을 올바르게 파싱하는지 확인하는 테스트")
    void testParseCarNames() throws Exception {
        Method parseMethod = InputView.class.getDeclaredMethod("parseCarNames", String.class);
        parseMethod.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<String> result = (List<String>) parseMethod.invoke(null, "car1,car2,car3");

        assertThat(result).hasSize(3);
        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("자동차 이름의 앞뒤 공백을 제거하여 파싱하는지 확인하는 테스트")
    void testParseCarNamesWithSpaces() throws Exception {
        Method parseMethod = InputView.class.getDeclaredMethod("parseCarNames", String.class);
        parseMethod.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<String> result = (List<String>) parseMethod.invoke(null, " car1 , car2 , car3 ");

        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("유효한 자동차 이름은 예외를 발생시키지 않는지 확인하는 테스트")
    void testValidateCarName() throws Exception {
        Method validateMethod = InputView.class.getDeclaredMethod("validateCarName", String.class);
        validateMethod.setAccessible(true);

        assertThatCode(() -> {
            try {
                validateMethod.invoke(null, "car1");
                validateMethod.invoke(null, "abcde");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("5자를 초과하는 자동차 이름은 예외를 발생시키는지 확인하는 테스트")
    void testInvalidCarNameLength() throws Exception {
        Method validateMethod = InputView.class.getDeclaredMethod("validateCarName", String.class);
        validateMethod.setAccessible(true);

        assertThatThrownBy(() -> {
            try {
                validateMethod.invoke(null, "toolongname");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).hasRootCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단일 자동차 이름 파싱이 정상 동작하는지 확인하는 테스트")
    void testSingleCarNameParsing() throws Exception {
        Method parseMethod = InputView.class.getDeclaredMethod("parseCarNames", String.class);
        parseMethod.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<String> result = (List<String>) parseMethod.invoke(null, "car1");

        assertThat(result).hasSize(1);
        assertThat(result).containsExactly("car1");
    }

    @Test
    @DisplayName("경계값 길이의 자동차 이름이 정상 처리되는지 확인하는 테스트")
    void testBoundaryCarNameLength() throws Exception {
        Method validateMethod = InputView.class.getDeclaredMethod("validateCarName", String.class);
        validateMethod.setAccessible(true);

        assertThatCode(() -> {
            try {
                validateMethod.invoke(null, "12345");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("빈 자동차 이름은 예외를 발생시키는지 확인하는 테스트")
    void testEmptyCarName() throws Exception {
        Method validateMethod = InputView.class.getDeclaredMethod("validateCarName", String.class);
        validateMethod.setAccessible(true);

        assertThatThrownBy(() -> {
            try {
                validateMethod.invoke(null, "");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).hasRootCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백만 있는 자동차 이름은 예외를 발생시키는지 확인하는 테스트")
    void testWhitespaceOnlyCarName() throws Exception {
        Method parseMethod = InputView.class.getDeclaredMethod("parseCarNames", String.class);
        parseMethod.setAccessible(true);

        assertThatThrownBy(() -> {
            try {
                parseMethod.invoke(null, "   ,  ,   ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).hasRootCauseInstanceOf(IllegalArgumentException.class);
    }
}
