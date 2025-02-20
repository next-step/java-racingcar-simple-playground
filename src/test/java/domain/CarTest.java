package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static final NumberGenerator ALWAYS_MOVE = () -> 5;
    private static final NumberGenerator NEVER_MOVE = () -> 3;
    private static final NumberGenerator DUMMY_GENERATOR = () -> 0;

    @Test
    @DisplayName("랜덤값이 4 이상인 경우 자동차는 1칸 전진한다.")
    void movesWhenRandomIsFourOrMore() {
        Car car = new Car("Neo");
        car.move(ALWAYS_MOVE.generate());

        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("랜덤값이 3 이하인 경우 자동차는 멈춘다.")
    void staysStillWhenRandomIsThreeOrLess() {
        Car car = new Car("Neo");
        car.move(NEVER_MOVE.generate());

        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("자동차 이름이 Neo로 반환되어야 한다.")
    void shouldReturnCarNameAsNeo() {
        Car car = new Car("Neo");
        assertThat(car.getName()).isEqualTo("Neo");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이다.")
    void shouldInitializeCarPositionAsZero() {
        Car car = new Car("Neo");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
