package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @Test
    @DisplayName("생성된 난수가 4 이상이면 참을 반환하지 못할경우 예외를 발생시킨다.")
    void isMovable_True_WhenRandomIs4OrMore() {
        // 통제된 난수 4를 반환하는 익명 객체 주입
        Random controlledRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy(controlledRandom);

        assertThat(moveStrategy.isMovable()).isTrue();
    }

    @Test
    @DisplayName("생성된 난수가 3 이하면 거짓을 반환하지 못할 경우 예외를 발생시킨다.")
    void isMovable_False_WhenRandomIs3OrLess() {
        // 통제된 난수 3을 반환하는 익명 객체 주입
        Random controlledRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy(controlledRandom);

        assertThat(moveStrategy.isMovable()).isFalse();
    }
}

