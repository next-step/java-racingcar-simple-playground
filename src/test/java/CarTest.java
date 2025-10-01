import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 정상적으로 생성된다.")
    void createCarTest() {
        Car car = new Car("TestCar");
        assertEquals("TestCar", car.getName());
    }

    @Test
    @DisplayName("자동차 이름이 5 초과 시 예외")
    void carNameLengthTest(){
        assertThrows(IllegalArgumentException.class,()->{
            new Car("abcdef");
        });
    }

    @Test
    @DisplayName("4이상일 때 움직인다.")
    void moveTest() {
        Car car = new Car("A");
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("3이하일때 멈춤")
    void moveTest1() {
        Car car = new Car("B");
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("rounds가 2이상일때 누적 이동 확인")
    void MultipleMoveTest(){
        Car car = new Car("C");
        car.move(4);
        car.move(5);
        car.move(6);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
