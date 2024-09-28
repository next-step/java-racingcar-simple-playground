package domain.car;

import domain.racegame.MoveStrategy;
import domain.racegame.RandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CarsTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private Cars cars;

    private final int fixedRandomNumber = 5;

    @BeforeEach
    void setUp() {
        car1 = new Car("goldmong");
        car2 = new Car("ruka");
        car3 = new Car("kokodak");

        cars = new Cars(Arrays.asList(car1, car2, car3));
    }

    @Test
    @DisplayName("랜덤 숫자에 관계 없이 모든 자동차들은 움직인다.")
    void raceOneRoundTest_WhenMoveStrategyReturnTrue() {
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        cars.raceOneRound(alwaysMoveStrategy, new RandomNumberGenerator());

        Assertions.assertEquals(1, car1.getCarPosition());
        Assertions.assertEquals(1, car2.getCarPosition());
        Assertions.assertEquals(1, car3.getCarPosition());
    }

    @Test
    @DisplayName("랜덤 숫자에 관계 없이 모든 자동차들은 움직이지 않는다.")
    void raceOneRoundTest_WhenMoveStrategyReturnFalse() {
        MoveStrategy neverMoveStrategy = new NeverMoveStrategy();

        cars.raceOneRound(neverMoveStrategy, new RandomNumberGenerator());

        Assertions.assertEquals(0, car1.getCarPosition());
        Assertions.assertEquals(0, car2.getCarPosition());
        Assertions.assertEquals(0, car3.getCarPosition());
    }

    @Test
    @DisplayName("제일 많이 이동한 자동차, 즉 우승자를 찾는다.")
    void findWinnersTest_WhenOneCarHasMaxPosition() {
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        //모든 자동차들은 fixedRandomNumber와 관계 없이 항상 움직임
        car1.move(alwaysMoveStrategy, fixedRandomNumber);

        car2.move(alwaysMoveStrategy, fixedRandomNumber);
        car2.move(alwaysMoveStrategy, fixedRandomNumber);

        car3.move(new NeverMoveStrategy(), fixedRandomNumber);

        List<String> winners = cars.findWinners();

        Assertions.assertEquals(1, winners.size());
        Assertions.assertTrue(winners.contains("ruka"));
    }

    @Test
    @DisplayName("자동차의 위치가 모두 같을 때, 모두 우승자로 선정된다.")
    void findWinnersTest_WhenCarsHaveSameMaxPosition() {

        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        car1.move(alwaysMoveStrategy, fixedRandomNumber);
        car2.move(alwaysMoveStrategy, fixedRandomNumber);
        car3.move(alwaysMoveStrategy, fixedRandomNumber);

        List<String> winners = cars.findWinners();

        Assertions.assertEquals(3, winners.size());
        Assertions.assertTrue(winners.contains("goldmong"));
        Assertions.assertTrue(winners.contains("ruka"));
        Assertions.assertTrue(winners.contains("kokodak"));
    }
}