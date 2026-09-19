package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final int MOVABLE_MIN = 4;
    private static final int NON_MOVABLE_UNDER = 3;


    @Test
    void movesWhenNumberIsFourOrMore() {
        // 준비
        Car car = new Car("Green");
        // 실행
        car.move(MOVABLE_MIN);
        // 검증
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void nonMovesWhenNuberIsUnderFour() {
        // 준비
        Car car = new Car("Green");
        // 실행
        car.move(NON_MOVABLE_UNDER);
        // 검증
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @Test
    void acceptsFiveCharacterName() {
        // 준비
        String name = "Green";
        // 실행
        Car car = new Car(name);
        // 검증
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void rejectsSixCharacterName() {
        // 준비
        String name = "Greedy";
        // 실행 및 검증
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
