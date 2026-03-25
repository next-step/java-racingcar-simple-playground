package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.NumberGenerator;
import racingcar.generator.TestNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("이름 배열로 자동차 목록을 생성한다")
    void createCars() {
        List<Car> cars = Cars.createCars(new String[]{"pobi", "crong"});

        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("pobi", "crong");
    }

    @Test
    @DisplayName("자동차가 한번에 잘 움직인다.")
    void moveAll() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        Cars cars = new Cars(List.of(pobi, crong));
        NumberGenerator generator = new TestNumberGenerator(List.of(4, 3, 4, 4));
        cars.moveAll(generator);
        cars.moveAll(generator);

        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsExactly(2, 1);
    }

    @Test
    @DisplayName("한명이 우승한다")
    void getWinner() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        Cars cars = new Cars(List.of(pobi, crong));
        NumberGenerator generator = new TestNumberGenerator(List.of(4, 3, 4, 4));
        cars.moveAll(generator);
        cars.moveAll(generator);

        assertThat(cars.getWinners())
                .extracting(Car::getName)
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("다수가 우승한다")
    void getWinners() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        Cars cars = new Cars(List.of(pobi, crong));
        NumberGenerator generator = new TestNumberGenerator(List.of(4, 4, 4, 4));
        cars.moveAll(generator);
        cars.moveAll(generator);

        assertThat(cars.getWinners())
                .extracting(Car::getName)
                .containsExactly("pobi", "crong");
    }

    @Test
    @DisplayName("다수가 우승한다")
    void noWinner() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        Cars cars = new Cars(List.of(pobi, crong));

        assertThat(cars.getWinners()).isEmpty();
    }
}
