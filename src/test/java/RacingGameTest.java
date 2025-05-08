import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("우승 자동차 찾기(여러명)")
    void findWinner() {
        RandomNumber randomNumber = new RandomNumber(20);
        RacingCar racingCar1 = new RacingCar("붕붕이", randomNumber);
        RacingCar racingCar2 = new RacingCar("방방이", randomNumber);
        RacingCar racingCar3 = new RacingCar("탕탕이", randomNumber);

        RacingCar[] racingCar = {racingCar1, racingCar2, racingCar3};

        int testRound = 3;
        RacingGame racingGame = new RacingGame(racingCar);
        racingGame.runRace(testRound);

        assertThat(racingGame.getWinnerNum()).isEqualTo(3);
        assertThat(racingGame.getWinnerName()).containsExactlyInAnyOrder("붕붕이", "방방이", "탕탕이");
    }

    @Test
    @DisplayName("우승 자동차가 1명일 경우")
    void findSingleWinner() {
        RandomNumber randomNumber1 = new RandomNumber(20);
        RandomNumber randomNumber2 = new RandomNumber(30);
        RandomNumber randomNumber3 = new RandomNumber(40);
        RacingCar racingCar1 = new RacingCar("붕붕이", randomNumber1);
        RacingCar racingCar2 = new RacingCar("방방이", randomNumber2);
        RacingCar racingCar3 = new RacingCar("탕탕이", randomNumber3);


        RacingCar[] racingCar = {racingCar1, racingCar2, racingCar3};
        RacingGame racingGame = new RacingGame(racingCar);
        racingGame.runRace(0);

        assertThat(racingGame.getWinnerNum()).isEqualTo(1);
        assertThat(racingGame.getWinnerName()).containsExactly("탕탕이");
    }
}