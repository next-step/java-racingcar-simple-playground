package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.dto.CarProgress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.AlwaysTrueMoveStrategy;

class RaceManagerTest {

    @Test
    @DisplayName("전달된 시도 횟수만큼 자동차가 정상적으로 움직인다.")
    void shouldMoveCar_whenInputTryCount() {
        // given
        int tryCount = 3;
        List<String> carNames = List.of("dd");
        RaceManager raceManager = new RaceManager(carNames, tryCount);
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.moveOnce(alwaysTrueMoveStrategy);

        // then
        assertThat(raceManager.getRaceCars().getCarStatuses().stream()
                .map(CarProgress::position)
                .toList())
                .containsExactly(1);
    }

    @Test
    @DisplayName("전달된 시도 횟수만큼 자동차가 정상적으로 움직인다.")
    void shouldMoveCars_whenInputTryCount() {
        // given
        int tryCount = 3;
        List<String> carNames = List.of("pobi", "dd", "juno");
        RaceManager raceManager = new RaceManager(carNames, tryCount);
        AlwaysTrueMoveStrategy alwaysTrueMoveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.moveOnce(alwaysTrueMoveStrategy);

        // then
        assertThat(raceManager.getRaceCars().getCarStatuses().stream()
                .map(CarProgress::position)
                .toList())
                .containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("한 명의 우승자을 정상적으로 반환한다.")
    void shouldReturnSingleWinnerName() {
        // given
        int tryCount = 1;
        List<String> carNames = List.of("pobi");
        RaceManager raceManager = new RaceManager(carNames, tryCount);
        AlwaysTrueMoveStrategy moveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.moveOnce(moveStrategy);

        // then
        assertThat(raceManager.findWinnerNames())
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("우승자들을 정상적으로 반환한다.")
    void shouldReturnMultiWinnerNames() {
        // given
        int tryCount = 1;
        List<String> carNames = List.of("pobi", "dd");
        RaceManager raceManager = new RaceManager(carNames, tryCount);
        AlwaysTrueMoveStrategy moveStrategy = new AlwaysTrueMoveStrategy();

        // when
        raceManager.moveOnce(moveStrategy);

        // then
        assertThat(raceManager.findWinnerNames())
                .containsExactly("pobi", "dd");
    }
}
