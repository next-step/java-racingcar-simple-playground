package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상인 경우 자동차는 1칸 전진한다.")
    void movesWhenRandomIsFourOrMore() {
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        Car car = new Car("Neo", fixedRandom);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("랜덤값이 3 이하인 경우 자동차는 멈춘다.")
    void staysStillWhenRandomIsThreeOrLess() {
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Car car = new Car("Neo", fixedRandom);
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("자동차 이름이 Neo로 반환되어야 한다.")
    void shouldReturnCarNameAsNeo() {
        Car car = new Car("Neo", new Random());
        assertThat(car.getName()).isEqualTo("Neo");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이다.")
    void shouldInitializeCarPositionAsZero() {
        Car car = new Car("Neo", new Random());
        assertThat(car.getPosition()).isEqualTo(0);
    }
}