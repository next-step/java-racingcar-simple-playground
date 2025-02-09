import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.NameParser;
import util.Validation;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입력한 값을 검증하는 기능 테스트")
public class ValidationTest {
    private Validation validation;
    private NameParser nameParser;

    @BeforeEach
    public void beforeEach() {
        validation = new Validation();
        nameParser = new NameParser();
    }

    @DisplayName("입력한 이름의 파싱이 제대로 되는가")
    @Test
    public void testNameParse() {
        String str = "neo,brie,brown";

        List<String> nameList = nameParser.parseName(str);

        assertThat(nameList).containsExactly("neo", "brie", "brown");

    }

    @DisplayName("이름들이 정상적으로 입력된 경우 예외를 발생하지 않는가")
    @Test
    public void testNameCorrectFormat() {
        String str = "neo,brie,brown";

        List<String> nameList = nameParser.parseName(str);

        Assertions.assertDoesNotThrow(() -> {
                    nameList.forEach((name) -> {
                        validation.validName(name);
                    });
                }
        );
    }

    @DisplayName("이름들이 비정상적으로 입력된 경우 예외를 발생하지 않는가")
    @ParameterizedTest
    @ValueSource(strings = {"", ",", ",neo", "neo,"})
    public void testNameIncorrectFormat(String str) {
        List<String> nameList = nameParser.parseName(str);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    nameList.forEach((name) -> {
                        validation.validName(name);
                    });
                }
        );
    }

    @DisplayName("시도 횟수가 정상적으로 입력된 경우 예외를 발생시키지 않는가")
    @Test
    public void testTimesCorrectFormat() {
        String strTimes = "5";

        Assertions.assertDoesNotThrow(() -> {
            validation.validTimes(strTimes);
        });
    }

    @DisplayName("시도 횟수가 비정상적으로 입력된 경우 예외를 발생시키지 않는가")
    @ParameterizedTest
    @ValueSource(strings = { "-5", "asdf", "!!!", "" })
    public void testTimesInCorrectFormat(String strTimes) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validation.validTimes(strTimes);
        });
    }
}
