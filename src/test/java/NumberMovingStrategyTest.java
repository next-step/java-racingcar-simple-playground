import domain.NumberMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberMovingStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    @DisplayName("4이상일 때 움직이는지 테스트")
    void 숫자가_4_이상이면_전진(int number) {
        NumberMovingStrategy strategy = new NumberMovingStrategy();

        assertThat(strategy.isMovable(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    @DisplayName("3이하일 때 안 움직이는지 테스트")
    void 숫자가_3_이하면_멈춤(int number) {
        NumberMovingStrategy strategy = new NumberMovingStrategy();

        assertThat(strategy.isMovable(number)).isFalse();
    }
}
