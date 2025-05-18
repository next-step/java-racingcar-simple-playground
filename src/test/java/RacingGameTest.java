import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.RacingGame;
import racinggame.model.car.policy.strategy.MoveStrategy;

import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("공동 우승자 발생한 경우 -> car1 car2")
    void 공동_우승자_발생 () {
        // given
        MoveStrategy dummystrategy=()->1;
        RacingGame game = new RacingGame(List.of("car1", "car2"), dummystrategy);

        // when
        game.moveOneTurn();

        // then
        List<String> winners = game.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("car1", "car2");
    }
}
