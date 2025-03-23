package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    Game game;
    CarManager carManager;

    @BeforeEach
    void BeforeEach() {
        Queue<Integer> numbers = new LinkedList<>(List.of(
                3, 3, 3,
                4, 4, 4,
                3, 4, 4
        ));
        NumberGenerator numberGenerator = new FakeGenerator(numbers);
        carManager = new CarManager(numberGenerator);
        game = new Game(carManager);
    }

    @Test
    @DisplayName("차량을 추가하면 carManger에 차량이 들어가야한다")
    void 차량을_추가하면_carManger에_차량이_들어가야한다() {
        //given
        Car car = Car.createCar("car");
        game.addCar(car);

        //when
        List<Car> cars = carManager.findAllCar();

        //then
        assertThat(cars).containsExactly(car);
    }

    @Test
    @DisplayName("game이 우승자를 정상적으로 찾는다")
    void game이_우승자를_정상적으로_찾는다() {
        //given
        Car car1 = Car.createCar("car1");
        Car car2 = Car.createCar("car2");
        Car car3 = Car.createCar("car3");
        game.addCar(car1);
        game.addCar(car2);
        game.addCar(car3);

        //when
        for (int i = 0; i < 3; i++) {
            game.turn();
        }
        List<Car> winners = game.findWinner();

        //then
        assertThat(winners).containsExactly(car2, car3);
    }


    @Test
    @DisplayName("game이_모든차량을_정상적으로_반환한다")
    void game이_모든차량을_정상적으로_반환한다() {
        //given
        Car car1 = Car.createCar("car1");
        Car car2 = Car.createCar("car2");
        Car car3 = Car.createCar("car3");
        game.addCar(car1);
        game.addCar(car2);
        game.addCar(car3);

        //when
        List<Car> allCar = game.findAllCar();

        //then
        assertThat(allCar).containsExactly(car1, car2, car3);
    }

}