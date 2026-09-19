package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자다")
    void returnsSingleWinnerWhenOneCarLeads() {
        Car a = new Car("A");
        Car b = new Car("B");
        a.moveIfPossible(4);
        a.moveIfPossible(5);
        b.moveIfPossible(4);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactly(a);
    }

    @Test
    @DisplayName("공동 우승자가 있을 수 있다")
    void returnsMultipleWinnersWhenTied() {
        Car a = new Car("A");
        Car b = new Car("B");
        a.moveIfPossible(4);
        b.moveIfPossible(4);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactlyInAnyOrder(a, b);
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 4이상이면 모든 자동차가 전진한다")
    void allCarsMoveForward_whenRandomNumberIsFourOrMore(int number) {
        Car a = new Car("A");
        Car b = new Car("B");
        Cars cars = new Cars(List.of(a, b));

        cars.move(new FixedRandomNumber(number));

        assertThat(a.getCarPosition()).isEqualTo(1);
        assertThat(b.getCarPosition()).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤값이 3이하면 모든 자동차가 정지한다")
    void allCarsStay_whenRandomNumberIsThreeOrLess(int number) {
        Car a = new Car("A");
        Car b = new Car("B");
        Cars cars = new Cars(List.of(a, b));

        cars.move(new FixedRandomNumber(number));

        assertThat(a.getCarPosition()).isEqualTo(0);
        assertThat(b.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarsTest() {
        Cars cars = Cars.createCars(new String[]{" neo", " brie ", "brown"});
        //공백이 있어도 잘 만들어지는지...
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("neo");
        assertThat(cars.getCars().get(1).getCarName()).isEqualTo("brie");
        assertThat(cars.getCars().get(2).getCarName()).isEqualTo("brown");
    }

}
