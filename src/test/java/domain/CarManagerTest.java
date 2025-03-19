package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

class CarManagerTest {

    CarManager carManager;

    @BeforeEach
    void beforeEach() {
        Queue<Integer> numbers = new LinkedList<>(List.of(2, 3, 4, 5));
        NumberGenerator numberGenerator = new FakeGenerator(numbers);
        carManager = new CarManager(numberGenerator);
    }

    @Test
    @DisplayName("모든 차량을 반횐한다")
    void 모든_차량을_반횐_한다() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        carManager.addCar(car1);
        carManager.addCar(car2);
        carManager.addCar(car3);

        //when
        List<Car> cars = carManager.findAllCar();

        //then
        assertThat(cars).containsExactly(car1, car2, car3);
    }

    @Test
    @DisplayName("차량의 수를 반환한다")
    void 차량의_수를_반환한다() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        carManager.addCar(car1);
        carManager.addCar(car2);
        carManager.addCar(car3);

        //when
        int carNumber = carManager.getCarNumber();
        //then
        assertThat(carNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("차량의 이동여부를 검증한후 차량을 이동시킨다")
    void 차량의_이동여부를_검증한후_차량을_이동시킨다() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        Car car4 = new Car("car4");

        carManager.addCar(car1);
        carManager.addCar(car2);
        carManager.addCar(car3);
        carManager.addCar(car4);

        //when
        carManager.moveIfCan();

        //then
        assertThat(car1.getDistance()).isEqualTo(0);
        assertThat(car2.getDistance()).isEqualTo(0);
        assertThat(car3.getDistance()).isEqualTo(1);
        assertThat(car4.getDistance()).isEqualTo(1);

    }

    @Test
    @DisplayName("차량이 없을 경우 예외를 던진다")
    void 차량이_없을_경우_예외를_던진다() {
        //then
        assertThatThrownBy(() -> carManager.moveIfCan())
                .isInstanceOf(IllegalStateException.class);
    }
}