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
        Car car = new Car("car");
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
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        game.addCar(car1);
        game.addCar(car2);
        game.addCar(car3);

        //when
        game.gameStart(3);
        List<Car> winners = game.findWinner();

        //then
        assertThat(winners).containsExactly(car2, car3);
    }

    @Test
    @DisplayName("game이 게임의 데이터를 정상적으로 저장한다")
    void game이_게임의_데이터를_정상적으로_저장한다() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        game.addCar(car1);
        game.addCar(car2);
        game.addCar(car3);

        //when
        game.gameStart(3);
        List<Car> winners = game.findWinner();
        List<List<Car>> gameHistory = game.getGameHistory();

        //then
        List<Car> carsHistory1 = gameHistory.get(0);
        assertThat(carsHistory1.get(0).getDistance()).isEqualTo(0);
        assertThat(carsHistory1.get(1).getDistance()).isEqualTo(0);
        assertThat(carsHistory1.get(2).getDistance()).isEqualTo(0);

        List<Car> carsHistory2 = gameHistory.get(1);
        assertThat(carsHistory2.get(0).getDistance()).isEqualTo(1);
        assertThat(carsHistory2.get(1).getDistance()).isEqualTo(1);
        assertThat(carsHistory2.get(2).getDistance()).isEqualTo(1);

        List<Car> carsHistory3 = gameHistory.get(2);
        assertThat(carsHistory3.get(0).getDistance()).isEqualTo(1);
        assertThat(carsHistory3.get(1).getDistance()).isEqualTo(2);
        assertThat(carsHistory3.get(2).getDistance()).isEqualTo(2);
    }
}