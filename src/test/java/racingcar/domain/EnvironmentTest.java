package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;


@SuppressWarnings("NonAsciiCharacters")
public class EnvironmentTest {

    @Test
    void 장애물이_있으면_통과할_수_없다() {
        Environment environment = new Environment(new ObstaclesAhead.Blocked());
        assertThat(asStream(environment)).allMatch(result -> result == Environment.MoveResult.STOP);
    }

    @Test
    void 장애물이_없으면_통과할_수_있다() {
        Environment environment = new Environment(new ObstaclesAhead.NoObstacles());
        assertThat(asStream(environment)).allMatch(result -> result == Environment.MoveResult.MOVE);
    }

    private Stream<Environment.MoveResult> asStream(Environment environment) {
        return Stream.generate(environment::tryAdvance)
                .limit(10);
    }


}
