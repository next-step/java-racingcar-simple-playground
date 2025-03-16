import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    void carStopTest() {
        //given
        Car car = new Car("car1");
        CarController carController = new CarController();

        //when
        carController.moveIfCan(3, car);

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void catMoveTest() {

        //given
        Car car = new Car("car1");
        CarController carController = new CarController();

        //when
        carController.moveIfCan(4, car);

        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void carMoveInGameTest() {
        //given
        Queue<Integer> queue = new LinkedList<>(List.of(4, 4));
        Game game = new Game(2, 1, new FakeGenerator(queue));
        Car car = new Car("car");
        game.addCar(car);

        //when
        game.gameStart();

        //then
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void carStopInGameTest() {
        //given
        Queue<Integer> queue = new LinkedList<>(List.of(3, 3));
        Game game = new Game(2, 1, new FakeGenerator(queue));
        Car car = new Car("car");
        game.addCar(car);

        //when
        game.gameStart();

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void shouldThrowExceptionWhenExceedingCarLimit() {
        //given
        Queue<Integer> queue = new LinkedList<>(List.of(1,1));
        Game game = new Game(1, 1, new FakeGenerator(queue));
        game.addCar(new Car("car1"));

        //then
        assertThatThrownBy(() -> game.addCar(new Car("car2")))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void gameTest() throws InterruptedException {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Queue<Integer> queue = new LinkedList<> (List.of(
                3, 4, 4,
                3, 5, 5,
                3, 4, 5));
        NumberGenerator numberGenerator = new FakeGenerator(queue);
        Game game = new Game(3, 3, numberGenerator);
        game.addCar(car1);
        game.addCar(car2);
        game.addCar(car3);

        //when
        game.gameStart();

        //then
        assertThat(game.getWinners()).containsExactly(car2, car3);
    }

    @Test
    void gameTestWithNotCar() {
        //given
        Game game = new Game(2,2, new FakeGenerator(new LinkedList<>(List.of(1,2,3))));

        //when

        //then
        assertThatThrownBy(() -> game.gameStart())
                .isInstanceOf(NoSuchElementException.class);
    }
}