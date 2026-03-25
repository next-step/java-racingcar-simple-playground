package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int START_POSITION = 0;

    @Test
    void Car_객체_생성_시_이름을_갖고_초기_위치는_0이다() {
        //given
        String expectedName = "Red";
        //when
        Car car = new Car(expectedName);
        //then
        assertAll(
                () -> assertThat(car.getName()).isEqualTo(expectedName),
                () -> assertThat(car.getPosition()).isEqualTo(START_POSITION)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차는_4에서_9_사이_정수를_넣으면_전진한다(int movableValue) {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> movableValue);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_여러_번_이동할_수_있다() {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> MOVABLE_NUMBER);
        car.moveForward(() -> MOVABLE_NUMBER);
        car.moveForward(() -> MOVABLE_NUMBER);
        car.moveForward(() -> MOVABLE_NUMBER);
        //then
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차는_0에서_3_사이_정수를_넣으면_정지한다(int num) {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> num);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
