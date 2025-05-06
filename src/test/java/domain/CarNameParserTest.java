package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "  a, b,c  "," a , b,  c"})
    @DisplayName("자동차 문자열 파싱 테스트")
    void splitCarNamesString(String carNamesInput) {
        // Given
        CarNameParser carNameParser = new CarNameParser();
        List<String> expected = List.of("a", "b", "c");

        // When
        List<String> actual = carNameParser.parse(carNamesInput);

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}
