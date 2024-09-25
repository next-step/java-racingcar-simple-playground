import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @BeforeEach
    void setUp() {
        Cars.cars = null;
        Cars.carNames = null;
    }

    @DisplayName("자동차 이름 분리 테스트")
    @Test
    void testSplitCarName(){
        String input = "car1,car2,car3";

        Cars.splitCarName(input);

        assertEquals(3, Cars.carNames.length);
        assertArrayEquals(new String[]{"car1","car2","car3"},Cars.carNames);
    }

    @DisplayName("자동차 이름 분리 예외 발생 테스트")
    @Test
    void testSplitCarNameCheck(){
        String input = null;

        Exception exception = assertThrows(IllegalArgumentException.class,()->{
            Cars.splitCarName(input);
        });

        assertEquals("이름은 공백으로 입력될 수 없습니다.", exception.getMessage());
    }

    @DisplayName("자동차 생성 테스트")
    @Test
    void testGenerateCar(){
        String input = "car1,car2,car3";
        Cars.splitCarName(input);

        Cars.generateCar();

        List<Car> cars = Cars.cars;
        assertEquals(3, cars.size());
        assertEquals("car1",cars.get(0).getName());
        assertEquals("car2",cars.get(1).getName());
        assertEquals("car3",cars.get(2).getName());
    }

    @DisplayName("자동차 생성 예외 테스트")
    @Test
    void testGenerateCarException(){
        String input = "car11111";
        Cars.splitCarName(input);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cars.generateCar();
        });

        assertEquals("이름은 최대 5자까지만 가능합니다.", exception.getMessage());
    }
}
