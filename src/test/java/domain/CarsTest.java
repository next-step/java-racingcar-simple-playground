package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.CarTest.TestNumberGenerateStrategy;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 자동차들을_일괄적으로_움직일수_있다() {
        // given
        final int movePower = 5;
        final int stopPower = 1;
        final List<Car> cars = List.of(
                new Car(new TestNumberGenerateStrategy(List.of(movePower)), "kokodak"),
                new Car(new TestNumberGenerateStrategy(List.of(stopPower)), "royce")
        );
        final Cars racingCars = new Cars(cars);

        // when
        racingCars.move();

        // then
        assertThat(racingCars.getCars())
                .extracting("position")
                .containsExactly(1, 0);
    }

    @Test
    void 자동차들의_최대_위치를_찾을_수_있다() {
        // given
        final List<Car> cars = List.of(
                new Car(new RandomNumberGenerateStrategy(), "kokodak", 12),
                new Car(new RandomNumberGenerateStrategy(), "royce", 4),
                new Car(new RandomNumberGenerateStrategy(), "luca", 12)
        );
        final Cars racingCars = new Cars(cars);

        // when
        int maxPosition = racingCars.findMaxPosition();

        // then
        assertThat(maxPosition).isEqualTo(12);
    }

    @Test
    void 특정_위치에_있는_자동차들을_찾을_수_있다() {
        // given
        final List<Car> cars = List.of(
                new Car(new RandomNumberGenerateStrategy(), "kokodak", 4),
                new Car(new RandomNumberGenerateStrategy(), "royce", 4),
                new Car(new RandomNumberGenerateStrategy(), "luca", 3)
        );
        final Cars racingCars = new Cars(cars);

        // when
        List<Car> carsWithPosition = racingCars.findCarsWithPosition(4);

        // then
        assertThat(carsWithPosition)
                .extracting("name")
                .containsExactly("kokodak", "royce");
    }
}
