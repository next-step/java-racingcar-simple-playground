
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.car.policy.decider.MoveDecider;
import racinggame.model.car.policy.numbergenerator.RandomGenerator;
import racinggame.model.car.policy.strategy.OneStepMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class OneStepMoveStrategyTest {

    @Test
    @DisplayName("Decider가 true일 때는 STEP_SIZE 만큼 반환")
    void returnsStepSizeWhenDeciderTrue() {
        // given
        RandomGenerator fixedGenerator = () -> 8;
        MoveDecider alwaysTrue = num -> true;
        OneStepMoveStrategy strat = new OneStepMoveStrategy(fixedGenerator, alwaysTrue);

        // when & then
        assertThat(strat.addStepSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("Decider가 false일 때는 0 반환")
    void returnsZeroWhenDeciderFalse() {
        // given
        RandomGenerator fixedGenerator = () -> 2;
        MoveDecider alwaysFalse = num -> false;
        OneStepMoveStrategy strategy = new OneStepMoveStrategy(fixedGenerator, alwaysFalse);

        // when & then
        assertThat(strategy.addStepSize()).isZero();
    }
}
