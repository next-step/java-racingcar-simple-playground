package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveRuleTest {

    @Test
    @DisplayName("규칙에 따라 4이상 이면 참으로 판단한다")
    void RuleBasedTrue() {

        boolean isTrue = MoveRule.canMove(4);

        assertThat(isTrue).isEqualTo(true);
    }

    @Test
    @DisplayName("규칙에 따라 3이하 이면 거짓으로 판단한다")
    void RuleBasedFalse() {
        boolean isTrue = MoveRule.canMove(3);

        assertThat(isTrue).isEqualTo(false);
    }
}
