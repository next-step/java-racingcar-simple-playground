package domain.racegame;

import domain.car.Car;
import domain.car.Cars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RacingGameTest {

    private RacingGame racingGame;
    Cars cars;

    @BeforeEach
    void setUp() {

        List<Car> carList = Arrays.asList(
                new Car("goldmong"),
                new Car("ruka"),
                new Car("pika")
        );

        cars = new Cars(carList);

        racingGame = new RacingGame(cars, 3);
    }

    @Test
    @DisplayName("첫 번째 라운드 후, 라운드가 진행 중인지 확인한다.")
    void isRaceOngoingTestWhenRaceIsNotFinished() {
        racingGame.playOneRoundRace();
        Assertions.assertTrue(racingGame.isRaceOngoing());

        racingGame.playOneRoundRace();
        Assertions.assertTrue(racingGame.isRaceOngoing());
    }

    @Test
    @DisplayName("3 라운드가 모두 끝난 후 race가 종료되었는지 확인한다.")
    void isRaceOngoingTestWhenRaceIsFinished() {
        racingGame.playOneRoundRace();
        racingGame.playOneRoundRace();
        racingGame.playOneRoundRace();

        Assertions.assertFalse(racingGame.isRaceOngoing());
    }
    
}