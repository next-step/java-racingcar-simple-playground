import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.View;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @DisplayName("자동차 이름 분리 테스트")
    @Test
    void testSplitCarName() {
        String input = "car1,car2,car3";

        View.splitCarName(input);

        /*
        assertEquals(3, cars.getCars().size());
        */


    }

    @DisplayName("자동차 이름 분리 예외 발생 테스트")
    @Test
    void testSplitCarNameCheck() {
        String input = null;

        /*

        Exception exception = assertThrows(IllegalArgumentException.class,()->{
            cars.splitCarName(input);
        });

        assertEquals("이름은 공백으로 입력될 수 없습니다.", exception.getMessage());

         */

        assertThatThrownBy(() -> View.splitCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백으로 입력될 수 없습니다.");
    }

    @DisplayName("자동차 생성 테스트")
    @Test
    void testGenerateCar() {
        String input = "car1,car2,car3";

        cars.generateCarWithNames(View.splitCarName(input));

        List<Car> testCars = cars.getCars();

        /*

        assertEquals(3, testCars.size());
        assertEquals("car1", testCars.get(0).getName());
        assertEquals("car2", testCars.get(1).getName());
        assertEquals("car3", testCars.get(2).getName());

         */

        assertThat(testCars).hasSize(3);
        assertThat(testCars.get(0).getName()).isEqualTo("car1");
        assertThat(testCars.get(1).getName()).isEqualTo("car2");
        assertThat(testCars.get(2).getName()).isEqualTo("car3");
    }

    @DisplayName("자동차 생성 예외 테스트")
    @Test
    void testGenerateCarException() {
        String input = "car11111";
        String[] carNames = View.splitCarName(input);

        /*

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cars.generateCar();
        });

        assertEquals("이름은 최대 5자까지만 가능합니다.", exception.getMessage());

         */

        assertThatThrownBy(() -> cars.generateCarWithNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5자까지만 가능합니다.");
    }

}
