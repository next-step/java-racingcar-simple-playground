package service;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RacingCar.RacingCar;
import domain.RacingGame.RacingGame;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameServiceTest {

    static RacingGameService racingGameService = new RacingGameService();

    @Test
    @DisplayName("참가자를 추가할 수 있다.")
    void initTest() {
        // given
        List<RacingCar> participants = List.of(
            new RacingCar("참가자1"),
            new RacingCar("참가자2"),
            new RacingCar("참가자3")
        );
        // when
        RacingGame racingGame = racingGameService.initGame(participants);
        // then
        assertThat(racingGame.getNumberOfParticipants())
            .isEqualTo(3);
    }

}
