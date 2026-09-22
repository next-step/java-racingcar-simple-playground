package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 라운드의_모든_자동차가_이동한다() {
        Cars cars = Cars.from(new String[]{"car1", "car2"});
        NumberGenerator generator = () -> 4;

        cars.move(generator);

        assertThat(cars.iterateCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 1);
    }

    @Test
    void 단독_우승자를_찾는다() {
        Cars cars = Cars.from(new String[]{"car1", "car2", "car3"});
        NumberGenerator numberGenerator = new SequenceNumberGenerator(
                4, 4, 3,
                3, 4, 3
        );

        cars.move(numberGenerator);
        cars.move(numberGenerator);

        assertThat(cars.findWinners())
                .extracting(Car::getName)
                .containsExactly("car2");
    }

    @Test
    void 공동_우승자를_찾는다() {
        Cars cars = Cars.from(new String[]{"car1", "car2", "car3"});
        NumberGenerator numberGenerator = new SequenceNumberGenerator(
                4, 4, 4,
                3, 4, 4
        );

        cars.move(numberGenerator);
        cars.move(numberGenerator);

        assertThat(cars.findWinners())
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car2", "car3");
    }

    @Test
    void 자동차이름들로_자동차_목록을_생성한다() {
        // given
        String[] names = new String[]{"car1",  "car2", "car3"};

        // when
        Cars cars = Cars.from(names);

        // then
        assertThat(cars.iterateCars())
                .extracting(Car::getName)
                .containsExactly("car1", "car2", "car3");
    }
}
