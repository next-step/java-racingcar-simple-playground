package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import model.dto.CarRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.AlwaysTrueMoveStrategy;

class RaceRecorderTest {

    @Test
    @DisplayName("자동차가 이동했을 때 정상적으로 기록한다.")
    void shouldRecordRound_whenMoveCar() {
        // given
        List<String> names = List.of("pobi", "woni");
        AlwaysTrueMoveStrategy strategy = new AlwaysTrueMoveStrategy();
        Cars cars = new Cars(names, strategy);
        RaceRecorder recorder = new RaceRecorder();

        // when
        cars.move();
        recorder.record(cars);

        // then
        List<RaceRound> rounds = recorder.getRaceRounds();
        assertEquals(1, rounds.size());

        RaceRound round = rounds.get(0);
        List<CarRecord> records = round.carRecords();

        assertThat(records)
                .hasSize(2)
                .extracting(CarRecord::name, CarRecord::position)
                .containsExactlyInAnyOrder(
                        tuple("pobi", 1),
                        tuple("woni", 1)
                );
    }
}
