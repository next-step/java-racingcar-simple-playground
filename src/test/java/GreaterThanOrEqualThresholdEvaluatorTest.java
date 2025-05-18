import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.car.policy.evaluator.GreaterThanOrEqualThresholdEvaluator;
import racinggame.model.car.policy.evaluator.ThresholdEvaluator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GreaterThanOrEqualThresholdEvaluatorTest {
    @Test
    @DisplayName("value가 threshold 이상이면 true")
    void threshold_이상이면_크면_참() {
        // given
        ThresholdEvaluator evaluator = new GreaterThanOrEqualThresholdEvaluator(4);

        // when
        boolean atThreshold=evaluator.isSatisfied(4);
        boolean aboveThreshold=evaluator.isSatisfied(5);

        // then
        assertThat(atThreshold).isTrue();
        assertThat(aboveThreshold).isTrue();
    }

    @Test
    @DisplayName("value가 threshold 미만이면 false")
    void threshold_미만이면_거짓() {
        // given
        ThresholdEvaluator evaluator = new GreaterThanOrEqualThresholdEvaluator(4);

        // when
        boolean belowThreshold=evaluator.isSatisfied(2);

        // then
        assertThat(belowThreshold).isFalse();

    }
}
