package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차는_이름을_가지고_있다() {
        Car car = new Car("횬다이");
        assertThat(car.getName()).isEqualTo("횬다이");
    }

    @Test
    void 자동차의_시작위치는_0이다() {
        Car car = new Car("횬다이");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 랜덤한_숫자가_4이상이면_전진한다() {
        Car car = new Car("횬다이");
        car.move(ThreadLocalRandom.current().nextInt(4, 9));
        assertThat(car.getPosition()).isOne();
    }

    @Test
    void 랜덤한_숫자가_3이하이면_정지한다() {
        Car car = new Car("횬다이");
        car.move(ThreadLocalRandom.current().nextInt(0, 3));
        assertThat(car.getPosition()).isZero();
    }
}
