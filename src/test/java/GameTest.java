import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void carStopTest() {
        //given
        List<Integer> list = new ArrayList<>();
        list.add(3);
        NumberGenerator numberGenerator = new FakeGenerator(list);
        Car car = new Car("car", numberGenerator);

        //when
        car.move();

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void catMoveTest() {
        //given
        List<Integer> list = new ArrayList<>();
        list.add(4);
        NumberGenerator numberGenerator = new FakeGenerator(list);
        Car car = new Car("car", numberGenerator);

        //when
        car.move();

        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void catMoveInGameTest() {
        //given
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        NumberGenerator numberGenerator = new FakeGenerator(list);
        Game game = new Game(2, 1);
        Car car = game.createCar("car", numberGenerator);

        //when
        game.gameStart();

        //then
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void gameTest() {
        //given
        Game game = new Game(2,2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        game.createCar("car1", new FakeGenerator(list1));

        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        Car car2 = game.createCar("car2", new FakeGenerator(list2));

        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(4);
        Car car3 = game.createCar("car3", new FakeGenerator(list3));

        //when
        game.gameStart();

        //then
        assertThat(game.getWinners()).containsExactly(car2, car3);
    }

    @Test
    void gameTestWithNotCar() {
        //given
        Game game = new Game(2,2);

        //when
        game.gameStart();

        //then
        assertThat(game.getWinners()).isEmpty();
    }
}