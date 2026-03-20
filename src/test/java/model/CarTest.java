package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 생성 시 이름과 초기 위치(0)를 올바르게 설정한다.")
    void createCar() {
        // given: "pobi"라는 이름을 가진 자동차를 준비하고
        String carName = "pobi";

        // when: 해당 이름으로 자동차를 생성하면
        Car car = new Car(carName);

        // then: 이름은 "pobi"이고 위치는 0이어야 한다.
        assertEquals(carName, car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("move 메서드를 호출하면 위치가 1 증가한다.")
    void moveCar() {
        // given: "woni"라는 이름의 자동차를 생성하고
        Car car = new Car("woni");

        // when: move 메서드를 한 번 호출하면
        car.move();

        // then: 자동차의 위치는 1이 되어야 한다.
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("move 메서드를 여러 번 호출하면 호출한 횟수만큼 위치가 증가한다.")
    void moveCarMultipleTimes() {
        // given: "jun"이라는 이름의 자동차를 생성하고
        Car car = new Car("jun");
        int moveCount = 5;

        // when: move 메서드를 5번 호출하면
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then: 자동차의 위치는 5가 되어야 한다.
        assertEquals(moveCount, car.getPosition());
    }
}
