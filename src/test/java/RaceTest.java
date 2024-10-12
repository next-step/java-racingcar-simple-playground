import domain.Car;
import domain.Race;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void 자동차_게임에는_여러_대의_자동차가_참여할_수_있다() {
        List<Car> cars = List.of(
                new Car("car1"), new Car("car2")
        );

        Race race = Race.createRace(cars, 1);

        assertThat(race.getCars())
                .usingRecursiveFieldByFieldElementComparator()
                .containsAnyElementsOf(cars);
    }

    @Test
    void 주어진_횟수_동안_전진_혹은_멈춘다() {
        List<Car> cars = List.of(
                new Car("car1",
                        new FixedNumberGenerator(4)),
                new Car("car2",
                        new FixedNumberGenerator(0))
        );

        Race race = Race.createRace(cars, 1);

        race.start();

        List<Car> expected = List.of(
                new Car("car1", 1),
                new Car("car2", 0)
        );

        List<Car> actual = race.getCars();

        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("numberGenerator")
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void 경주가_끝난_후_우승자를_구할_수_있다() {
        List<Car> cars = List.of(
                new Car("car1",
                        new FixedNumberGenerator(List.of(1,2,3,4))),
                new Car("car2",
                        new FixedNumberGenerator(List.of(5,6,7,8))),
                new Car("car3",
                        new FixedNumberGenerator(List.of(4,5,7,8)))
        );

        Race race = Race.createRace(cars, 4);

        race.start();

        List<Car> expected = List.of(
                new Car("car2", 4),
                new Car("car3", 4)
        );

        List<Car> actual = race.getWinner();

        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("numberGenerator")
                .containsExactlyInAnyOrderElementsOf(expected);

    }
}
