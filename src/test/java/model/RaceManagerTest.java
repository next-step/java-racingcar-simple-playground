package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.AlwaysTrueMoveStrategy;

class RaceManagerTest {

    @Test
    @DisplayName("전달된 시도 횟수만큼 자동차가 정상적으로 움직인다.")
    void shouldMoveCars_whenInputTryCount() {
        // given
        int tryCount = 3;
        List<String> carNames = List.of("pobi", "jiyun", "juno");
        RaceManager raceManager = new RaceManager(carNames, tryCount);
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.moveOnce(alwaysTrueMoveStrategy);

        // then
        assertThat(raceManager.getRaceCars().getCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("우승자를 정상적으로 반환한다.")
    void shouldReturnWinnerNames() {
        // given
        int tryCount = 1;
        List<String> carNames = List.of("pobi", "jiyun");
        RaceManager raceManager = new RaceManager(carNames, tryCount);
        AlwaysTrueMoveStrategy moveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.moveOnce(moveStrategy);

        // then
        assertThat(raceManager.findWinnerNames())
                .containsExactly("pobi", "jiyun");
    }
}
