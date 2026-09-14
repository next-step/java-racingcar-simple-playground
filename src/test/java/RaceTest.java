import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class RaceTest {
    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "0, false",
            "9, true"
    })
    void 숫자에_따라_이동가능여부가_결정된다(int number, boolean expected) {

        Race race = new Race(List.of("가"), new RandomMovement());

        assertThat(race.isMovable(number)).isEqualTo(expected);
    }
}
