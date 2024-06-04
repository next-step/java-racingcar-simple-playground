package controller;

import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    @DisplayName("게임 실행 결과를 나타낸다(우승차의 최종 위치: 3, 패배차의 최종 위치: 1)")
    @Test
    void race_test() {
        // given
        final Car winner = new Car("우승차", new ListMoveStrategy(new ArrayList<>(Arrays.asList(4, 5, 6, 3))));
        final Car loser = new Car("패배차", new ListMoveStrategy(new ArrayList<>(Arrays.asList(2, 1, 6, 3))));
        final Cars cars = new Cars(List.of(winner, loser));

        final RacingGameController controller = new RacingGameController(new RacingGame(cars, new RacingCount(4)));

        // when
        controller.race();

        // then
        final List<Car> result = controller.getRacingGame().getWinners();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(winner);
        assertThat(result.get(0).getPosition()).isEqualTo(3);
    }
}
