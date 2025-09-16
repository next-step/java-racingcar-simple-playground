import domain.Car;
import domain.Race;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {
    private static final int TEST_CAR_COUNT = 3;
    private static final int TEST_RACE_TURN = 5;

    @Test
    void 레이스의_우승자가_존재한다() { // 요구사항
        // given
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new FakeRandomDigitGenerator(5));
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 1),
                new Car("car3", 0)
        );

        // when
        List<Car> winners = race.playRace(cars, TEST_RACE_TURN);

        // then
        assertTrue(!winners.isEmpty());
    }

    @Test
    void 레이스의_우승자는_한명_존재할_수_있다() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 3),
                new Car("car3", 2)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new FakeRandomDigitGenerator(5));

        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0).getCarName());
    }

    @Test
    void 레이스의_우승자는_두명_이상_존재할_수_있다() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 2)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new FakeRandomDigitGenerator(5));

        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0).getCarName());
        assertEquals("car3", winners.get(1).getCarName());
    }

    @Test
    void 전진하지_않은_모두가_공동우승자일_수_있다() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 0),
                new Car("car3", 0)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new FakeRandomDigitGenerator(3));

        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertEquals(3, winners.size());
        assertEquals("car1", winners.get(0).getCarName());
        assertEquals("car2", winners.get(1).getCarName());
        assertEquals("car3", winners.get(2).getCarName());
    }

    static class FakeRandomDigitGenerator extends utils.RandomDigitGenerator {
        private final int fixed;

        FakeRandomDigitGenerator(int fixed) {
            this.fixed = fixed;
        }

        @Override
        public int generateRandomDigit() {
            return fixed;
        }
    }
}
