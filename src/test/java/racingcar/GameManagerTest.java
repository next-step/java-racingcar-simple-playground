package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @DisplayName("랜덤 값이 4 이상인 경우에는 전진한다.")
    @Test
    void move() {
        // given
        Car car = new Car("test");
        int randomValue = 4;

        // when
        gameManager.move(car, randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3 이하일 경우에는 전진하지 않는다.")
    @Test
    void test() {
        // given
        Car car = new Car("test");
        int randomValue = 3;

        // when
        gameManager.move(car, randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}