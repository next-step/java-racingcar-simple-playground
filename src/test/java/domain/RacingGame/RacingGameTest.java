package domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RacingCar.RacingCar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    static RacingGame racingGame;

    @BeforeEach
    void initRacingGame() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("참가자의 숫자를 반환한다.")
    void addParticipantsTest() {
        // given
        List<RacingCar> participants = List.of(new RacingCar("참가1"),
                                               new RacingCar("참가2"),
                                               new RacingCar("참가3"));
        // when
        for (RacingCar participant : participants) {
            racingGame.addParticipant(participant);
        }
        // then
        assertThat(racingGame.getNumberOfParticipants())
            .isEqualTo(participants.size());
    }

    @Test
    @DisplayName("경기를 진행한 후, 우승자를 반환한다")
    void racingTest() {
        // given
        RacingCar racingCar1 = new RacingCar("참가자1");
        racingGame.addParticipant(racingCar1);
        RacingCar racingCar2 = new RacingCar("참가자2");
        racingGame.addParticipant(racingCar2);
        RacingCar racingCar3 = new RacingCar("참가자3");
        racingGame.addParticipant(racingCar3);
        List<Integer> randomNumbers = List.of(1, 0, 5);
        // when
        racingGame.race(randomNumbers);
        // then
        assertThat(racingGame.getWinner())
            .contains(racingCar3)
            .hasSize(1);
    }

    @Test
    @DisplayName("우승자가 여러 명이면 여러 명을 모두 반환한다.")
    void racingTest2() {
        // given
        RacingCar racingCar1 = new RacingCar("참가자1");
        racingGame.addParticipant(racingCar1);
        RacingCar racingCar2 = new RacingCar("참가자2");
        racingGame.addParticipant(racingCar2);
        RacingCar racingCar3 = new RacingCar("참가자3");
        racingGame.addParticipant(racingCar3);
        List<Integer> randomNumbers = List.of(1, 5, 5);
        // when
        racingGame.race(randomNumbers);
        // then
        assertThat(racingGame.getWinner())
            .contains(racingCar2)
            .contains(racingCar3)
            .hasSize(2);
    }
}
