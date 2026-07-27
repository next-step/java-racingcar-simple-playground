package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import support.SequenceNumberGenerator;
import support.FixedNumberGenerator;

import java.util.List;
import java.util.Arrays;

public class RacingGameTest {
    @Test
    @DisplayName("한 라운드에 자동차 여러대가 각자 이동한다")
    void movesMultipleCars() {
        NumberGenerator numberGenerator = new SequenceNumberGenerator(Arrays.asList(4, 3, 7));

        List<String> carNames = Arrays.asList("test1", "test2", "test3");

        RacingGame racingGame = new RacingGame(carNames, numberGenerator);

        racingGame.playRound();

        List<CarSnapshot> cars = racingGame.getCarSnapshots();

        assertEquals(1, cars.get(0).getPosition());
        assertEquals(0, cars.get(1).getPosition());
        assertEquals(1, cars.get(2).getPosition());
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 한 대이면 우승자도 한 명이다")
    void findWinnerWithMaxPosition() {
        NumberGenerator numberGenerator = new SequenceNumberGenerator(Arrays.asList(3, 3, 7, 3, 3, 7));

        List<String> carNames = Arrays.asList("test1", "test2", "test3");

        RacingGame racingGame = new RacingGame(carNames, numberGenerator);

        racingGame.playRound();
        racingGame.playRound();

        List<CarSnapshot> winners = racingGame.findWinners();

        assertEquals(1, winners.size());
        assertEquals("test3", winners.get(0).getName());
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러 대이면 우승자도 여러 명이다")
    void findAllWinnersWithMaxPosition() {
        NumberGenerator numberGenerator = new SequenceNumberGenerator(Arrays.asList(4, 3, 7));

        List<String> carNames = Arrays.asList("test1", "test2", "test3");

        RacingGame racingGame = new RacingGame(carNames, numberGenerator);

        racingGame.playRound();

        List<CarSnapshot> winners = racingGame.findWinners();

        assertEquals(2, winners.size());
        assertEquals("test1", winners.get(0).getName());
        assertEquals("test3", winners.get(1).getName());
    }

    @Test
    @DisplayName("모든 자동차의 위치가 같으면 모두 공동 우승자이다")
    void findsAllCarsAsWinnersWhenPositionsAreEqual() {
        NumberGenerator numberGenerator = new FixedNumberGenerator(2);

        List<String> carNames = Arrays.asList("test1", "test2", "test3");

        RacingGame racingGame = new RacingGame(carNames, numberGenerator);

        List<CarSnapshot> winners = racingGame.findWinners();

        assertEquals(3, winners.size());
    }
}
