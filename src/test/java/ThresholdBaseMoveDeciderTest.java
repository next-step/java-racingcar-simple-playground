import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.car.policy.decider.MoveDecider;
import racinggame.model.car.policy.decider.ThresholdBaseMoveDecider;
import racinggame.model.car.policy.evaluator.ThresholdEvaluator;

import static org.assertj.core.api.Assertions.assertThat;


class ThresholdBaseMoveDeciderTest {

    @Test
    @DisplayName("Evaluator 결과를 그대로 리턴한다")
    void evaluator_결과_리턴 () {
        // given
       ThresholdEvaluator evaluator = new ThresholdEvaluator() {
            @Override
            public boolean isSatisfied(int value) {
                return value == 7;
            }
        };
        MoveDecider decider = new ThresholdBaseMoveDecider(evaluator);

        // when & then
        assertThat(decider.canMove(7)).isTrue();
        assertThat(decider.canMove(2)).isFalse();

    }
}
