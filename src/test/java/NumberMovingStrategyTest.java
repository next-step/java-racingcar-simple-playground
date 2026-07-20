import domain.NumberMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberMovingStrategyTest {

    @Test
    @DisplayName("4이상일 때 움직이는지 테스트")
    void movableTest() {
        int number = 4;

        NumberMovingStrategy strategy = new NumberMovingStrategy();

        assertThat(strategy.isMovable(number)).isTrue();
    }

    @Test
    @DisplayName("3이하일 때 안 움직이는지 테스트")
    void notMovableTest() {
        int number = 3;

        NumberMovingStrategy strategy = new NumberMovingStrategy();

        assertThat(strategy.isMovable(number)).isFalse();
    }
}
