import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.NameParser;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NameParserTest {

    @ParameterizedTest
    @MethodSource("provideNamesAndExpectedLists")
    void 이름이_정상적으로_파싱되는지_테스트(String input, List<String> expected) {
        List<String> actual = NameParser.parse(input);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideNamesAndExpectedLists() {
        return Stream.of(
                Arguments.of("neo,brie,brown", List.of("neo", "brie", "brown")),
                Arguments.of("neo,,brown", List.of("neo", "", "brown")),
                Arguments.of("", List.of("")),
                Arguments.of(",", List.of("", ""))
        );
    }
}
