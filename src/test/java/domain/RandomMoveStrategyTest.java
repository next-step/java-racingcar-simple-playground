package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @DisplayName("RandomMoveStrategy는 랜덤하게 true 또는 false를 반환한다.")
    @Test
    void randomlyReturnTrueOrFalse() {
        RandomMoveStrategy strategy = new RandomMoveStrategy();
        boolean result1 = strategy.canMove();
        boolean result2 = strategy.canMove();

        assertThat(result1 != result2).isTrue();
    }

    @DisplayName("RandomMoveStrategy는 일정 횟수 이상 호출하면 true와 false를 모두 반환한다.")
    @Test
    void returnBothTrueAndFalse() {
        RandomMoveStrategy strategy = new RandomMoveStrategy();
        List<Boolean> results = IntStream.range(0, 1000)
                .mapToObj(i -> strategy.canMove())
                .toList();

        assertThat(results).contains(true);
        assertThat(results).contains(false);
    }

    @DisplayName("RandomMoveStrategy는 일정 확률로 true와 false를 반환한다.")
    @Test
    void returnTrueAndFalseWithProbability() {
        RandomMoveStrategy strategy = new RandomMoveStrategy();
        int trueCount = 0;
        int falseCount = 0;

        for (int i = 0; i < 10000; i++) {
            if (strategy.canMove()) {
                trueCount++;
            } else {
                falseCount++;
            }
        }

        assertThat(trueCount).isBetween(5500, 6500);
        assertThat(falseCount).isBetween(3500, 4500);
    }
}