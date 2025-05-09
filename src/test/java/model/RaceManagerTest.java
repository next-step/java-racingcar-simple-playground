package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.AlwaysTrueMoveStrategy;

class RaceManagerTest {

    @Test
    @DisplayName("전달된 시도 횟수만큼 자동차가 정상적으로 움직인다.")
    void shouldMoveCars_whenInputTryCount() {
        // given
        int tryCount = 3;
        String carNames = "pobi,jiyun,juno";
        RaceManager raceManager = new RaceManager(tryCount, carNames);
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.start(alwaysTrueMoveStrategy);

        // then
        assertThat(raceManager.getAllPositions())
                .containsExactly(3, 3, 3);
    }

    @Test
    @DisplayName("우승자를 정상적으로 반환한다.")
    void shouldReturnWinnerNames() {
        // given
        int tryCount = 1;
        String carNames = "pobi,jiyun";
        RaceManager raceManager = new RaceManager(tryCount, carNames);
        AlwaysTrueMoveStrategy moveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.start(moveStrategy);

        // then
        assertThat(raceManager.findWinnerNames())
                .containsExactly("pobi", "jiyun");
    }
}
