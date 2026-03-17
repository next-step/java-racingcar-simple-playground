package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int START_POSITION = 0;

    @Test
    @DisplayName("Car 객체 생성: Car 객체 생성 후, 이름과 초기 위치 확인")
    void create_Car() {
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

    @Test
    @DisplayName("Car 객체 생성 실패(이름 오류): 에러 메시지 확인")
    void createFail_Car() {
        //given
        String emptyName = "";
        String overlongName = "GREENORANGE";
        //when
        IllegalArgumentException e1 = Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(emptyName));
        IllegalArgumentException e2 = Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(overlongName));
        //then
        assertAll(
                () -> assertThat(e1.getMessage()).isEqualTo("비어 있는 이름은 허용되지 않습니다."),
                () -> assertThat(e2.getMessage()).isEqualTo("10자를 초과하는 이름은 허용되지 않습니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("앞으로 단일 이동: 이동 조건이 성립할 경우, 위치 1 증가 확인.")
    void move_Forward(int movableValue) {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> movableValue);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("앞으로 다회 이동: 여러 번 이동도 정상적으로 작동하는지 확인.")
    void move_MultiForward() {
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
    @DisplayName("자동차 정지: 이동 조건이 성립하지 않을 경우, 위치는 변화 없음 확인.")
    void move_Stop(int num) {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> num);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
