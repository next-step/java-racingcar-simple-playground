import domain.Car;
import domain.Race;
import org.junit.jupiter.api.Test;
import utils.RandomDigitGenerator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {
    private static final int TEST_CAR_COUNT = 3;
    private static final int TEST_RACE_TURN = 5;

    // getMaxPosition 테스트
    @Test
    void getMaxPosition_최대값_계산() {
        List<Car> cars = Arrays.asList(
                new Car("testCar1", 0),
                new Car("testCar2", 0),
                new Car("testCar3", 0)
        );
        cars.get(0).move(9);
        cars.get(0).move(9);
        cars.get(1).move(9);
        Race race = new Race(3, 5, new RandomDigitGenerator());
        assertEquals(2, race.getMaxPosition(cars));
    }

    //playSingleTurn 테스트
    @Test
    void playSingleTurn_한_턴_진행() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("a", 0),
                new Car("b", 1),
                new Car("c", 0)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new RandomDigitGenerator());
        RandomDigitGenerator fixedDigit = new RandomDigitGenerator() {
            @Override
            public int generateRandomDigit() {
                return 9;
            }
        };

        // when
        race.playSingleTurn(cars, fixedDigit);

        // then
        assertEquals(
                List.of(1, 2, 1),
                cars.stream().map(Car::getCarPosition).toList()
        );
    }

    // getWinner 테스트
    @Test
    void getWinner_레이스의_우승자가_존재한다() {
        // given
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new RandomDigitGenerator());
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 1),
                new Car("car3", 0)
        );

        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertTrue(!winners.isEmpty());
    }

    @Test
    void getWinner_레이스의_우승자는_한명_존재할_수_있다() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 3),
                new Car("car3", 2)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new RandomDigitGenerator());

        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0).getCarName());
    }

    @Test
    void getWinner_레이스의_우승자는_두명_이상_존재할_수_있다() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 2)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new RandomDigitGenerator());

        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0).getCarName());
        assertEquals("car3", winners.get(1).getCarName());
    }

    @Test
    void getWinner_전진하지_않은_모두가_공동우승자일_수_있다() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 0),
                new Car("car3", 0)
        );
        Race race = new Race(TEST_CAR_COUNT, TEST_RACE_TURN, new RandomDigitGenerator());
        
        // when
        List<Car> winners = race.getWinner(cars);

        // then
        assertEquals(3, winners.size());
        assertEquals("car1", winners.get(0).getCarName());
        assertEquals("car2", winners.get(1).getCarName());
        assertEquals("car3", winners.get(2).getCarName());
    }

}
