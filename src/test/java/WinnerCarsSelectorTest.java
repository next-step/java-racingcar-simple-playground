import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnerCarsSelectorTest {

    @Test
    @DisplayName("자동차들 중 우승 자동차를 고를 수 있다.")
    public void selectWinnerCar() {
        //given
        Car car1 = new Car("자동차1", 0);
        Car car2 = new Car("자동차2", 3);
        Car car3 = new Car("자동차3", 5);
        Car car4 = new Car("자동차4", 9);
        Car car5 = new Car("자동차5", 5);

        List<Car> cars = new ArrayList<Car>(List.of(car1, car2, car3, car4, car5));
        List<Car> expected = new ArrayList<Car>(List.of(car4));

        WinnerCarsSelector winnerCarsSelector = new WinnerCarsSelector();

        //when
        List<Car> result = winnerCarsSelector.selectWinnerCars(cars);

        //then
        //usingRecursiveAssertions() : 객체 참조값이 아닌 객체의 내용을 비교하는 것
        Assertions.assertThat(result).usingRecursiveAssertion().isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차들 중 최대 길이가 같은 자동차가 여러대라면 우승 자동차는 하나 이상이 될 수 있다.")
    public void selectWinnerCars() {
        //given
        Car car1 = new Car("자동차1", 0);
        Car car2 = new Car("자동차2", 3);
        Car car3 = new Car("자동차3", 9);
        Car car4 = new Car("자동차4", 9);
        Car car5 = new Car("자동차5", 4);

        List<Car> cars = new ArrayList<Car>(List.of(car1, car2, car3, car4, car5));
        List<Car> expected = new ArrayList<Car>(List.of(car3, car4));

        WinnerCarsSelector winnerCarsSelector = new WinnerCarsSelector();

        //when
        List<Car> result = winnerCarsSelector.selectWinnerCars(cars);

        //then
        //usingRecursiveAssertions() : 객체 참조값이 아닌 객체의 내용을 비교하는 것
        Assertions.assertThat(result).usingRecursiveAssertion().isEqualTo(expected);
    }
}
