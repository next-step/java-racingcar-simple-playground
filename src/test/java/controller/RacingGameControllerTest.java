package controller;

import model.Cars;
import model.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingGameControllerTest {
    private Cars cars;

    @Test
    @DisplayName("레이싱 게임에서 우승자가 정상적으로 선정되는 지 검증한다")
    void testSelectWinnersAfterRace() {

        cars = new Cars(List.of("car1", "car2"));
        RacingGame racingGame = new RacingGame(cars);
        RacingGameController racingGameController = new RacingGameController();

        racingGameController.runRace(5, racingGame, cars);

        assertThat(cars.getWinners()).isNotEmpty();
    }
}
