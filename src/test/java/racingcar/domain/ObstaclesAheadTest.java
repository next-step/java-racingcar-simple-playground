package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@SuppressWarnings("NonAsciiCharacters")
public class ObstaclesAheadTest {

    @Nested
    public class ByRandomTest {

        @ParameterizedTest
        @ValueSource(longs = {0, 1, 2, 3, 4})
        void 장애물을_피할_수_있다(long seed) {
            ObstaclesAhead avoidance = new ObstaclesAhead.ByRandom(seed);
            assertThat(asStream(avoidance)).contains(ObstaclesAhead.Result.AVOIDED, ObstaclesAhead.Result.BLOCKED);
        }

        @ParameterizedTest
        @ValueSource(longs = {0, 1, 2, 3, 4})
        void 피할_확률이_60퍼센트에_수렴한다(long seed) {
            ObstaclesAhead avoidance = new ObstaclesAhead.ByRandom(seed);

            long results = Stream.generate(avoidance::tryAvoid)
                    .limit(500)
                    .filter(result -> result == ObstaclesAhead.Result.AVOIDED)
                    .count();

            assertThat(results).isBetween(5 * 55L, 5 * 65L);
        }

    }


    private Stream<ObstaclesAhead.Result> asStream(ObstaclesAhead avoidance) {
        return Stream.generate(avoidance::tryAvoid)
                .limit(10);
    }

}
