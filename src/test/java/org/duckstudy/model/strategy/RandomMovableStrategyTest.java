package org.duckstudy.model.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("랜덤 이동 전략 테스트")
class RandomMovableStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("random 값이 4 이상 9 이하인 경우 true를 반환한다")
    void moveCarWhenRandomValueIsGreaterThanOrEqual4(int randomValue) {
        RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy(() -> randomValue);

        assertThat(randomMovableStrategy.isMovable()).isTrue();
    }

    @Test
    @DisplayName("random 값이 3 이하인 경우 false를 반환한다")
    void stopCarWhenRandomValueIsLessThan4() {
        RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy(() -> 3);

        assertThat(randomMovableStrategy.isMovable()).isFalse();
    }
}
