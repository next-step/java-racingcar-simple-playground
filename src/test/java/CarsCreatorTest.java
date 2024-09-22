import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CarsCreator;

import java.util.ArrayList;
import java.util.List;

public class CarsCreatorTest {

    @Test
    @DisplayName("자동차 이름목록으로 자동차를 생성할 수 있다")
    public void createCarsByCarNames() {
        //given
        List<String> carNames = new ArrayList<String>(List.of("car1"));
        List<Car> expected = new ArrayList<Car>(List.of(new Car("car1", 0)));

        //when
        List<Car> result = CarsCreator.createCars(carNames);

        //then
        // Q : usingRecursiveAssertion() vs usingRecursiveComparison()의 차이??
        Assertions.assertThat(result.get(0).getCarName()).isEqualTo("car1");
        Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

}
