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
        assertThat(Race.isMovable(number)).isEqualTo(expected);
    }

    @Test
    void 우승자가_한명일때_반환한다() {
        Cars cars = new Cars(List.of(
                new Car("A", 4),
                new Car("AB", 4),
                new Car("ABC", 5),
                new Car("ABCD", 2)

        ));

        Race race = new Race(cars);
        List<Car> winners = race.findWinners();
        assertThat(winners).extracting(Car::getName).containsExactly("ABC");
    }

    @Test
    void 우승자가_한명이상일때_반환한다() {
        Cars cars = new Cars(List.of(
                new Car("A", 4),
                new Car("AB", 4),
                new Car("ABC", 5),
                new Car("ABCD", 2),
                new Car("ABCDE", 5)

        ));

        Race race = new Race(cars);
        List<Car> winners = race.findWinners();
        assertThat(winners).extracting(Car::getName).containsExactly("ABC", "ABCDE");
    }
}
