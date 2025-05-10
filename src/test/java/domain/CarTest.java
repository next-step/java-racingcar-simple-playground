package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("초기 위치는 0이다")
    void initialPositionIsZero() {
        Car car = new Car(new Name("콜라"));

        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("NumberGenerator가 4 이상을 반환하면 위치가 1 증가한다")
    void carMovesWhenGeneratedNumberIsGreaterThanOrEqualToThreshold() {
        NumberGenerator generator = () -> 4;
        MoveCondition condition = new MoveCondition(generator);
        Car car = new Car(new Name("사이다"));

        car.move(condition);

        assertThat(car.getPosition().getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("NumberGenerator가 3 이하를 반환하면 위치는 그대로 유지된다")
    void carDoesNotMoveWhenGeneratedNumberIsLessThanThreshold() {
        NumberGenerator generator = () -> 3;
        MoveCondition condition = new MoveCondition(generator);
        Car car = new Car(new Name("환타"));

        car.move(condition);

        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }
}
