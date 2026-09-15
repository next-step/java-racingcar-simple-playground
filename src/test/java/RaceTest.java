import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "0, false",
            "9, true"
    })

    void 숫자에_따라_이동가능여부가_결정된다(int number, boolean expected) {
        assertThat(Race.isMovable(number)).isEqualTo(expected);
    }

    @Test
    void 우승자가_한명일때_반환한다() {
        
    }

    @Test
    void 우승자가_한명이상일때_반환한다() {

    }
}
