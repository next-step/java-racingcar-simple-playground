package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


class WinnerFinderTest {

    WinnerFinder winnerFinder = new WinnerFinder();

    @Test
    @DisplayName("우승자 리스트를 찾아서 반환한다")
    void 우승자_리스트를_찾아서_반환한다() {
        //given
        List<Car> cars = new LinkedList<>();
        Car car1 = Car.createCar("car1");
        Car car2 = Car.createCar("car2");
        Car car3 = Car.createCar("car3");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        car1.move();
        car1.move();

        car2.move();
        car2.move();

        //when
        List<Car> winners = winnerFinder.findWinner(cars);

        //then
        Assertions.assertThat(winners).containsExactly(car1, car2);
    }
}