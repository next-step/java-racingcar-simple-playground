package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CarTest {

    @Test
    void 자동차는_4이상일때_움직인다() {
        // given
        NumberGenerateStrategy strategy = new TestNumberGenerateStrategy(
                new ArrayList<>(Arrays.asList(4))
        );
        final Car car = new Car(strategy, "kokodak");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_4미만일때_움직이지_않는다() {
        // given
        NumberGenerateStrategy strategy = new TestNumberGenerateStrategy(
                new ArrayList<>(Arrays.asList(3))
        );
        final Car car = new Car(strategy, "kokodak");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "8, true",
            "4, false"
    })
    void 임의의_위치가_자동차의_현재_위치와_같은지_판단할_수_있다(final int position, final boolean expected) {
        // given
        final Car car = new Car(new RandomNumberGenerateStrategy(),
                                "kokodak",
                                8);

        // when
        final boolean actual = car.isPositionSame(position);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static class TestNumberGenerateStrategy implements NumberGenerateStrategy {

        private final List<Integer> numbers;

        public TestNumberGenerateStrategy(final List<Integer> numbers) {
            this.numbers = new ArrayList<>(numbers);
        }

        @Override
        public int generate() {
            if (numbers.isEmpty()) {
                throw new IllegalStateException("더 이상 숫자를 생성할 수 없습니다.");
            }
            return numbers.remove(0);
        }
    }
}
