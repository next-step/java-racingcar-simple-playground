package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

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

    static class TestNumberGenerateStrategy implements NumberGenerateStrategy {

        private final List<Integer> numbers;

        public TestNumberGenerateStrategy(final List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
