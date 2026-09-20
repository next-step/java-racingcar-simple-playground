package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자다")
    void returnsSingleWinnerWhenOneCarLeads() {
        Car a = new Car("A", 7);
        Car b = new Car("B", 2);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactly(a);
    }

    @Test
    @DisplayName("공동 우승자가 있을 수 있다")
    void returnsMultipleWinnersWhenTied() {
        Car a = new Car("A", 3);
        Car b = new Car("B", 3);

        Cars cars = new Cars(List.of(a, b));

        assertThat(cars.findWinner()).containsExactlyInAnyOrder(a, b);
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 4이상이면 모든 자동차가 전진한다")
    void allCarsMoveForward_whenRandomNumberIsFourOrMore(int number) {
        Car a = new Car("A", 0);
        Car b = new Car("B", 0);
        Cars cars = new Cars(List.of(a, b));

        cars.move(new FixedRandomNumber(number));

        assertThat(a.getCarPosition()).isEqualTo(1);
        assertThat(b.getCarPosition()).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤값이 3이하면 모든 자동차가 정지한다")
    void allCarsStay_whenRandomNumberIsThreeOrLess(int number) {
        Car a = new Car("A", 0);
        Car b = new Car("B", 0);
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

    @Test
    @DisplayName("같은 이름의 자동차가 있으면 예외가 발생")
    void throwsException_whenDuplicateNamesExist() {
        Car a = new Car("A", 0);
        Car b = new Car("A", 0);

        assertThatThrownBy(() -> new Cars(List.of(a, b)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
