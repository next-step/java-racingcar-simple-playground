import model.Car;
import model.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.Car.MAX_CAR_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("자동차의 이름을 불러올 경우 그 이름을 반환해야 한다.")
    void should_ReturnCarName_When_CarNameCalled() {
        Car car = new Car("Alice", new TestRandomNumberGenerator((Arrays.asList(4, 3, 2, 9, 6, 0))));
        assertThat(car.getName()).isEqualTo("Alice");
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이라면 자동차가 전진하여야 하며, 3 이하라면 전진하지 않아야 한다.")
    void should_MoveCar_IfRandomValueIsFourOrAbove() {
        Car car = new Car("Bob", new TestRandomNumberGenerator((Arrays.asList(4, 3, 2, 9, 6, 0))));
        assertThat(car.getDistance()).isEqualTo(0);

        car.moveByProbability();
        assertThat(car.getDistance()).isEqualTo(1);

        car.moveByProbability();
        assertThat(car.getDistance()).isEqualTo(1);

        for (int i = 1; i <= 4; i++) {
            car.moveByProbability();
        }
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차의 이름이 비어 있을 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_IfCarLengthIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("  ", new TestRandomNumberGenerator(Arrays.asList(1, 2)));
        });

        assertEquals("[ERROR] 자동차의 이름은 비어 있어서는 안 됩니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차의 이름이 정해진 제한 글자를 넘었을 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_IfCarLengthExceededAllowedLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("MyNameIsTooLong", new TestRandomNumberGenerator(Arrays.asList(1, 2)));
        });

        assertEquals("[ERROR] 자동차의 이름의 길이는 " + MAX_CAR_NAME_LENGTH + "자를 넘어서는 안 됩니다.", exception.getMessage());
    }
}
