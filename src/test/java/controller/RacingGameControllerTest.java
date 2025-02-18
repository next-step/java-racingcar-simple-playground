package controller;

import model.Cars;
import model.RacingGame;
import model.RandomUtil;
import model.RandomValueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    private Cars cars;
    private RandomUtil randomValueGenerator;
    private static final int RACE_ROUNDS = 5;

    @Test
    @DisplayName("레이싱 게임에서 우승자가 정상적으로 선정되는 지 검증한다")
    void testSelectWinnersAfterRace() {

        cars = new Cars(List.of("car1", "car2"));
        randomValueGenerator = new RandomValueGenerator();

        RacingGame racingGame = new RacingGame(cars,randomValueGenerator);
        RacingGameController racingGameController = new RacingGameController();

        racingGameController.runRace(RACE_ROUNDS, racingGame, cars);

        assertThat(cars.getWinners()).isNotEmpty();
    }
}
