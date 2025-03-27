package repository;

import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarRepositoryTest {

    CarRepository carRepository;

    @BeforeEach
    void afterEach() {
        carRepository = new CarRepository();
    }

    @Test
    @DisplayName("모든 차량을 찾아서 반환한다.")
    void findAllTest() {
        //given
        Car car1 = Car.createCar("car1");
        Car car2 = Car.createCar("car2");
        carRepository.addCar(car1);
        carRepository.addCar(car2);

        //when
        List<Car> cars = carRepository.findAll();

        //then
        Assertions.assertThat(cars).containsExactly(car1, car2);
    }

    @Test
    @DisplayName("차량의 수를 반환한다.")
    void getCarNumberTest() {
        //given
        Car car1 = Car.createCar("car1");
        Car car2 = Car.createCar("car2");
        Car car3 = Car.createCar("car3");
        Car car4 = Car.createCar("car4");
        carRepository.addCar(car1);
        carRepository.addCar(car2);
        carRepository.addCar(car3);
        carRepository.addCar(car4);

        //when
        int carNumber = carRepository.getCarNumber();

        //then
        Assertions.assertThat(carNumber).isEqualTo(4);
    }
}